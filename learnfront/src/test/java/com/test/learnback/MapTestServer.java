package com.test.learnback;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.learncommon.service.GsmsContactService;

/**
 * 
 * @Description: TODO(启动模块入口)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年10月20日
 * @Version 1.0.0
 */
public class MapTestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		MapGenerecTest mapGenerecTest = context.getBean(
				"mapTest", MapGenerecTest.class);
		System.out.println(mapGenerecTest.getMaps());
	}

}
