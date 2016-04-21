package com.learnback.work.lightweb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.junit.Test;
import org.xlightweb.GetRequest;
import org.xlightweb.HttpRequest;
import org.xlightweb.IHttpRequest;
import org.xlightweb.IHttpResponse;
import org.xlightweb.client.HttpClient;

public class XLightWebTest {

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 18080;

	private static URI createUrl() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		String protocal = "http://";
		String path = "cgi-bin/sendsms?";
		String userName = "user01@ent01";
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

	
	
	@Test
	public void sendSms() {
		HttpClient client = new HttpClient();
		try {
			IHttpRequest request = new GetRequest(createUrl().toString());
			IHttpResponse response = client.call(request);
			System.out.println(response.getResponseHeader());
			System.out.println(response.getBlockingBody().readString());
			client.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
