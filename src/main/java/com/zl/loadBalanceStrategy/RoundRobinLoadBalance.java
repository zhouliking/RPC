package com.zl.loadBalanceStrategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** 
* RoundRobinLoadBalance：按照权重轮询
* 每一次把来自用户的请求轮流分配给内部中的服务器。如：从1开始，
* 一直到N(其中，N是内部服务器的总个数)，然后重新开始循环
* @author 周力 
*/
public class RoundRobinLoadBalance implements LoadBalance{

	private static int next = 0;
	
	@Override
	public String selectOneServer(List<String> servers) {
		synchronized(this){
			return servers.get(next++ % servers.size());
		}
	}

}
