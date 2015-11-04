package com.learnback.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learnback.service.GsmsContactService;

/**
 * 
 * @Description: TODO(启动模块入口)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年10月20日
 * @Version 1.0.0
 */
public class LearnBackServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		GsmsContactService contactService = context.getBean(
				"defaultGsmsContactService", GsmsContactService.class);
		System.out.println(contactService.selectByPrimaryKey(1));
	}

}
