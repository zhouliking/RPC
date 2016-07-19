package com.zl.loadBalanceStrategy;

import java.util.List;

/** 
* 
* @author 周力 
*/
public interface LoadBalance {
	
	public String selectOneServer(List<String> servers);

}
