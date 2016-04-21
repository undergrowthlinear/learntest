package com.learnback.work;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class HttpOriginalTest {

	private static final String HOST = "172.16.22.243";
	private static final int PORT = 8086;

	@Test
	public void sendSms() {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(createUrl());
		HttpHost httpHost = new HttpHost(HOST, PORT);
		StringBuffer sb = new StringBuffer();
		try {
			HttpResponse response = httpClient.execute(httpGet);
			HttpEntity entry = response.getEntity();
			if (entry != null) {
				InputStreamReader is = new InputStreamReader(entry.getContent());
				BufferedReader br = new BufferedReader(is);
				String str = null;
				while ((str = br.readLine()) != null) {
					sb.append(str.trim());
				}
				br.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb.toString());

	}

	private static URI createUrl() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		String protocal = "http://";
		String path = "cgi-bin/sendsms?";
		String userName = "admin@ent01";
		String password = "123456";
		String to = "18287131062";
		String msgtype = "1";
		URI uri = null;
		try {
			String text = URLEncoder.encode("测试HTTP", "GBK");
			builder.append(protocal);
			builder.append(HOST);
			builder.append(":" + PORT + "/");
			builder.append(path);
			builder.append("username=" + userName + "&");
			builder.append("password=" + password + "&");
			builder.append("to=" + to + "&");
			builder.append("msgtype=" + msgtype + "&");
			builder.append("text=" + text);
			uri = new URI(builder.toString());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}

}
