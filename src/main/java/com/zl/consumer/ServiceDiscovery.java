package com.zl.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import com.zl.constant.Constant;
import com.zl.loadBalanceStrategy.LoadBalance;

public class ServiceDiscovery {

	private CountDownLatch latch;
	private String registryAddress;
	private String service;

	private volatile List<String> servers = new ArrayList<String>();
	private LoadBalance strategy;

	public ServiceDiscovery(String registryAddress, String service, LoadBalance strategy) {
		this.registryAddress = registryAddress;
		this.service = service;
		this.strategy = strategy;

		ZooKeeper zk = connectServer();
		System.out.println(zk);
		if (zk != null) {
			discover(zk);
		}
	}

	public String selectOneServer() {
		return strategy.selectOneServer(servers);
	}

	private void discover(final ZooKeeper zk) {
		try {
			servers = zk.getChildren(Constant.ZK_DATA_PATH + "/" + service, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getType() == Event.EventType.NodeChildrenChanged) {
						discover(zk);
					}
				}
			});
			// System.out.println(servers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ZooKeeper connectServer() {
		ZooKeeper zk = null;
		latch = new CountDownLatch(1);
		try {
			zk = new ZooKeeper(registryAddress, Constant.ZK_SESSION_TIMEOUT, new Watcher() {
				public void process(WatchedEvent event) {
					if (event.getState() == Event.KeeperState.SyncConnected) {
						latch.countDown();
					}
				}
			});

			latch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zk;
	}
}
