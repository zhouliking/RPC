package com.zl.loadBalanceStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * RandomStrategy：按照权重随机选择
 * @author 周力
 */
public class RandomLoadBalance implements LoadBalance {

	private Random random = new Random();
	private Map<String, Integer> weightMap;

	public RandomLoadBalance() {
		weightMap = new HashMap<String, Integer>();
		weightMap.put("127.0.0.1:8000", 1);
		weightMap.put("127.0.0.2:8000", 3);
		weightMap.put("127.0.0.3:8000", 5);
		weightMap.put("127.0.0.4:8000", 7);
	}

	@Override
	public String selectOneServer(List<String> servers) {
		int length = servers.size();
		boolean sameWeight = true;//所有server权重均一样，为true
		int totalWeight = 0;
		for (int i = 0; i < length; i++) {
			int weight = weightMap.get(servers.get(i));
			totalWeight += weight; // 累计总权重
			if (sameWeight && i > 0 && weight != weightMap.get(servers.get(i - 1))) {
				sameWeight = false; // 计算所有权重是否一样
			}
		}
		//权重均不相同，按照权重随机
		if (totalWeight > 0 && !sameWeight) {		
			int offset = random.nextInt(totalWeight);		
			for (int i = 0; i < length; i++) {
				offset -= weightMap.get(servers.get(i));
				if (offset < 0) {
					return servers.get(i);
				}
			}
		}
		//权重相同，则直接随机
		return servers.get(random.nextInt(length));

	}
}
