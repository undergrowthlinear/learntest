package com.learnback.work.lightweb;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.xlightweb.BadMessageException;
import org.xlightweb.HttpResponse;
import org.xlightweb.IHttpExchange;
import org.xlightweb.IHttpRequest;
import org.xlightweb.IHttpRequestHandler;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @Description: TODO(自定义Request处理器)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月16日
 * @Version 1.0.0
 */
public class MyRequestHandler implements IHttpRequestHandler {

	@Override
	public void onRequest(IHttpExchange exchange) throws IOException,
			BadMessageException {
		// TODO Auto-generated method stub
		IHttpRequest request = exchange.getRequest();
		/*
		 * for (String attribute : request.getAttributeNameSet()) {
		 * System.out.println(attribute + ":" +
		 * request.getAttribute(attribute)); }
		 */
		/*
		 * System.out.println("Request Header"); for (String headAttribute :
		 * request.getHeaderNameSet()) { System.out.println(headAttribute + ":"
		 * + request.getHeader(headAttribute)); }
		 */
		String contentString = request.getBody().readString("utf-8");
		System.out.println(request.getCharacterEncoding() + "\t"
				+ request.getRemoteHost() + "\t" + request.getRequestUrl()
				+ "\t" + contentString);
		Map<String, Integer> reMap = createMap();
		exchange.send(new HttpResponse(200, "text/plain", URLEncoder.encode(
				JSONArray.toJSONString(reMap), "utf-8")));
	}

	private Map<String, Integer> createMap() {
		Map<String, Integer> reMap = new HashMap<String, Integer>();
		for (int i = 0; i < 10; i++) {
			reMap.put("测试" + i, i);
		}
		return reMap;
	}

}
