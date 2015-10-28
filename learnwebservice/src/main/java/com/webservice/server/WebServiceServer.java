package com.webservice.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.webservice.proxy.UserWebService;

public class WebServiceServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		UserWebService userWebService=context.getBean("userWebService", UserWebService.class);
		System.out.println(userWebService);
		while(true){}
	}

}
