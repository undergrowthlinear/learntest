package com.learnback.work.lightweb;

import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.xlightweb.BlockingBodyDataSource;
import org.xlightweb.BodyDataSink;
import org.xlightweb.BodyDataSource;
import org.xlightweb.BodyForwarder;
import org.xlightweb.FutureResponseHandler;
import org.xlightweb.GetRequest;
import org.xlightweb.HttpRequestHeader;
import org.xlightweb.IHttpRequest;
import org.xlightweb.IHttpResponse;
import org.xlightweb.client.HttpClient;

@SuppressWarnings("deprecation")
public class XlightWebClient {

	HttpClient client = null;

	@Before
	public void Before() {
		client = new HttpClient();
		client.setFollowsRedirect(true);
		client.setAutoHandleCookies(false);
	}

	/**
	 * 同步传输
	 */
	@Test
	public void getRequest() {
		// TODO Auto-generated method stub
		IHttpRequest request = null;
		try {
			request = new GetRequest(
					"http://localhost:11111/?name=%E5%BC%A0%E4%B8%89");
			IHttpResponse response = client.call(request);
			System.out.println(response.getStatus());
			BlockingBodyDataSource dataSource = response.getBlockingBody();
			System.out.println(dataSource.readString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 异步请求
	 */
	@Test
	public void getRequestOfFutureResponse() {
		String url = "http://localhost:11111/?name=%E5%BC%A0%E4%B8%89";
		try {
			FutureResponseHandler future = new FutureResponseHandler();
			HttpRequestHeader header = new HttpRequestHeader("GET", url);
			BodyDataSink bodyDataSink = client.send(header, future);
			// bodyDataSink.transferFrom(source);
			bodyDataSink.close();
			IHttpResponse response = future.getResponse(); // blocks until the
															// response header
															// is received
			System.out.println(response.getStatus() + "\t"
					+ response.getReason());
			if (response.getStatus() != 200) {
				throw new IOException("got status " + response.getStatus());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 自定义异步请求
	 */
	@Test
	public void getRequestOfCustomResponse() {
		String url = "http://localhost:11111/?name=%E5%BC%A0%E4%B8%89";
		MyResponseHandler responseHandler = new MyResponseHandler();
		try {
			BodyDataSink data = client.send(new HttpRequestHeader("GET", url),
					responseHandler);
			data.close();
			IHttpResponse response = responseHandler.getResponse(3 * 60 * 1000,
					TimeUnit.MILLISECONDS);
			if (response != null) {
				System.out.println(response.getStatus() + "\t"
						+ response.getReason()+"\t"+response.getBody().readString());
			} else
				throw new NullPointerException("等待3*60*1000未获取到响应");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (client != null)
					client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
