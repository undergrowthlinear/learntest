package com.learnback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.impl.client.DefaultHttpClient;
public class AlivedIpCheckerTest {
	
    public static void main(String[] args) {
    	
    	DefaultHttpClient httpClient = new DefaultHttpClient();
	 	String proxyHost = "120.195.193.120";
	 	int proxyPort = 80;
	 	String userName = "";
	 	String password = "";
	 	HttpGet httpGet = new HttpGet("https://www.baidu.com");
	 	
		httpClient.getCredentialsProvider().setCredentials(
	    new AuthScope(proxyHost, proxyPort),
	    new UsernamePasswordCredentials(userName, password));
	    HttpHost proxy = new HttpHost(proxyHost,proxyPort);
	    httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);	    
	    //StringBuffer sb = new StringBuffer();
	    
		try {
			HttpResponse response = httpClient.execute(httpGet);
			if(response.getStatusLine().getStatusCode()==200){
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println("代理服务器可用");							
			}else{
				System.out.println("接收到响应为:"+response);
				System.out.println("代理无效");	
			}
//			HttpEntity entry = response.getEntity();
//			if(entry != null){
//				InputStreamReader is = new InputStreamReader(entry.getContent());
//				BufferedReader br = new BufferedReader(is);
//				String str = null;
//				while((str = br.readLine()) != null){
//					sb.append(str.trim());
//				}
//				br.close();
//			} 
		 } catch (ClientProtocolException e) {
			 	e.printStackTrace();
		 	} catch (IOException e) {
		 		e.printStackTrace();
		 	}
		 		//System.out.println(sb.toString());		

	}	 	 	 

}
