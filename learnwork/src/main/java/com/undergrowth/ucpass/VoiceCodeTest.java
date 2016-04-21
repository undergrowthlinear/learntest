package com.undergrowth.ucpass;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.junit.Before;
import org.junit.Test;
import org.xlightweb.IHttpRequest;
import org.xlightweb.IHttpResponse;
import org.xlightweb.PostRequest;
import org.xlightweb.client.HttpClient;

/**
 * 
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2016年3月28日
 * @Version 1.0.0
 */
public class VoiceCodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HttpClient client = null;
	String url = "https://api.ucpaas.com/2014-06-30/Accounts/";
	String accountSid = "4b651c5b2eee897abc725a1e8a74bb5b";
	String accountToken = "0406a97d4a9cc45f1c23df90d3120ccb";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	String contentType = "application/xml";
	String encode = "utf-8";
	String content = "测试post请求";

	@Before
	public void Before() {
		client = new HttpClient();
		client.setFollowsRedirect(true);
		client.setAutoHandleCookies(false);
	}

	@Test
	public void postRequest() {
		try {
			IHttpRequest request = createPostRequest();
			IHttpResponse response = client.call(request);
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * * @param url the url string
	 * 
	 * @param encoding
	 *            the encoding
	 * @param contentType
	 *            the content type
	 * @param body
	 *            the body
	 * @param compress
	 *            true, if the body should be compressed
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	private IHttpRequest createPostRequest() throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(url).append(accountSid).append("/");
		builder.append("?").append("sig=").append(createSigParameter());
		url=builder.toString();
		IHttpRequest request = new PostRequest(url, contentType, encode, content, true);
		return request;
	}

	/**
	 * sig= MD5（账户Id + 账户授权令牌 + 时间戳），共32位(注:转成大写) 使用MD5加密（账户Id + 账户授权令牌 +
	 * 时间戳），共32位 时间戳是当前系统时间（24小时制），格式“yyyyMMddHHmmss”。时间戳有效时间为50分钟。
	 * 
	 * @return
	 */
	private Object createSigParameter() {
		// TODO Auto-generated method stub
		String currentTimeStamp=simpleDateFormat.format(System.currentTimeMillis());
		String sigParameter=DigestUtils.md5Hex(accountSid+accountToken+currentTimeStamp);
		return sigParameter;
	}

}
