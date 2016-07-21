package com.zl.testRPC;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.zl.consumer.ServiceProxy;
import com.zl.interfaces.HelloService;

import junit.framework.Assert;

public class ConsumerTest  {
	@Autowired
    private ServiceProxy serviceProxy;
	
	@SuppressWarnings("resource")
	@Test
    public void helloTest() {
		new ClassPathXmlApplicationContext("consumer-cofig.xml");
        HelloService helloService = serviceProxy.create(HelloService.class);
        String result = helloService.hello("World");
        Assert.assertEquals("Hello! World", result);
    }
}
