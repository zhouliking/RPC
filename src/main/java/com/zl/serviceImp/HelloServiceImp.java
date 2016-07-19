package com.zl.serviceImp;

import com.zl.innotation.RpcService;
import com.zl.interfaces.HelloService;

@RpcService(HelloService.class) // ָ��Զ�̽ӿ�
public class HelloServiceImp implements HelloService   {

	public String hello(String name) {
		return "Hello " + name;
	}

	
}  
