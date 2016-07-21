package com.zl.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author 周力
 */
public class RpcBootstrap {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("provider-cofig.xml");
    }
}
