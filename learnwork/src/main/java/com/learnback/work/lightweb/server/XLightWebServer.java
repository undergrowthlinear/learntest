package com.learnback.work.lightweb.server;

import java.io.IOException;

import org.xlightweb.server.HttpServer;
import org.xlightweb.server.IHttpServer;

import com.learnback.work.lightweb.MyRequestHandler;

public class XLightWebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IHttpServer server=new HttpServer(11111, new MyRequestHandler());
			 server.setMaxTransactions(400);
			 server.setRequestTimeoutMillis(5 * 60 * 1000);  
			 server.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
