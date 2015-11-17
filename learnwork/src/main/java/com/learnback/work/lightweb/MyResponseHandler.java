package com.learnback.work.lightweb;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.xlightweb.IFutureResponse;
import org.xlightweb.IHttpResponse;
import org.xlightweb.IHttpResponseHandler;
import org.xlightweb.InvokeOn;

/**
 * 
 * @Description: TODO(自定义响应处理器)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月16日
 * @Version 1.0.0
 */
@InvokeOn(InvokeOn.HEADER_RECEIVED)
public class MyResponseHandler implements IHttpResponseHandler, IFutureResponse {

	private IHttpResponse response;
	private CountDownLatch latch = new CountDownLatch(1);

	@Override
	public void onResponse(IHttpResponse response) throws IOException {
		// TODO Auto-generated method stub
		this.response = response;
		latch.countDown();
	}

	@Override
	public void onException(IOException ioe) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(ioe.getMessage());
	}

	@Override
	public IHttpResponse getResponse() throws IOException,
			InterruptedException, SocketTimeoutException {
		// TODO Auto-generated method stub
		return getResponse(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
	}

	@Override
	public IHttpResponse getResponse(long timeout, TimeUnit unit)
			throws IOException, InterruptedException, SocketTimeoutException {
		// TODO Auto-generated method stub
		latch.await(timeout, unit);
		return response;
	}

	@Override
	public IHttpResponse get() throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		try {
			return getResponse();
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public IHttpResponse get(long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		try {
			return getResponse(timeout, unit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

}
