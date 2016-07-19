package com.zl.loadBalanceStrategy;

import java.util.List;

/** 
* 最少活跃数调用，慢的服务器将收到更少请求，
* 活跃数调用后记差，慢的提供者差会越来越大
* @author 周力 
*/
public class LeastActionLoadBalance  implements LoadBalance{

	public String selectOneServer(List<String> servers) {
		// TODO Auto-generated method stub
		return null;
	}

}
