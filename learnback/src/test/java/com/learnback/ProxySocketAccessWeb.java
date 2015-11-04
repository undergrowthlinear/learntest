package com.learnback;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Socket;
import java.net.URL;
 
public class ProxySocketAccessWeb {
 
	/**
	 * @param ip
	 * @param port
	 * @throws Exception
	 */
	static void http(String ip, int port) throws Exception {
		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("undergrowth", "csdn@u315457847"
						.toCharArray());
			}
		});
		// 此处可以是： HTTP、SOCKS5
		Proxy proxy = new Proxy(Proxy.Type.HTTP,
				new InetSocketAddress(ip, port));
		URL url = new URL("http://passport.csdn.net/account/login?from=http://my.csdn.net/my/mycsdn");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
		conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
		conn.setConnectTimeout(10000);
		 
		InputStream is = conn.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer text = new StringBuffer();
		String line = null;
		while ((line = in.readLine()) != null) {
			text.append(line);
		}
		if (is != null) {
			is.close();
		}
		if (conn != null) {
			conn.disconnect();
		}
		System.out.println(text.toString());
	}
	public static void main(String[] args) {
		try {
			http("127.0.0.1", 18052);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	