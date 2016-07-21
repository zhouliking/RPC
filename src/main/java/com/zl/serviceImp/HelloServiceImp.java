package com.zl.serviceImp;

import com.zl.innotation.RpcService;
import com.zl.interfaces.HelloService;
/**
 * 
 * @author 周力
 */
@RpcService(HelloService.class) 
public class HelloServiceImp implements HelloService   {
	public String hello(String name) {
		return "Hello " + name;
	}
}  
