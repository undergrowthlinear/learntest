/*package com.restful.webservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restful.webservice.entity.Greeting;

*//**
 * 
 * @Description: TODO(restful web services)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年12月28日
 * @Version 1.0.0
 *//*
@RestController
public class GreetingController {

	
	private static final String template = "Hello,%s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(counter.incrementAndGet(), String.format(template,
				name));
	}
}
*/