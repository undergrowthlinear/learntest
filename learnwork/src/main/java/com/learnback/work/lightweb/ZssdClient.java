package com.learnback.work.lightweb;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.xlightweb.BlockingBodyDataSource;
import org.xlightweb.GetRequest;
import org.xlightweb.IHttpRequest;
import org.xlightweb.IHttpResponse;
import org.xlightweb.PostRequest;
import org.xlightweb.client.HttpClient;

import com.learnback.work.entity.MO;
import com.learnback.work.entity.Report;
import com.learncommon.XmlBeanUtils;

@SuppressWarnings("deprecation")
public class ZssdClient {

	HttpClient client = null;
	String xmlHead = "<?xml version='1.0' encoding='UTF-8' ?>";
	String responseStartString = "<Response>";
	String responseEndString = "</Response>";
	String moString = "MO";
	String reportString = "Report";

	/**
	 * xml=<?xml version="1.0" encoding="UTF-8" ?>
<Response>
<MO>
<Mobile>18287131061</Mobile>
<Message><![CDATA[æ¶å°äº]]></Message>
<ReceiveTime>2015-12-3 15:00:04</ReceiveTime>
<ExtendCode>2350</ExtendCode>
<MsgID>305236265</MsgID>
</MO>
</Response>

	 */
	
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
	public void getMoRequest() {
		// TODO Auto-generated method stub
		IHttpRequest request = null;
		try {
			request = new PostRequest("http://127.0.0.1:7238/?xml="
					+ createMoText());
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
	 * 同步传输
	 */
	@Test
	public void getReportRequest() {
		// TODO Auto-generated method stub
		IHttpRequest request = null;
		try {
			request = new GetRequest("http://127.0.0.1:7239/?xml="
					+ createReportText());
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

	private String createMoText() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(xmlHead.replace('\'', '\"') + "\n");
		builder.append(responseStartString+ "\n");
		//
		Map<String, Class<?>> moMap = new HashMap<String, Class<?>>();
		moMap.put(moString, MO.class);
		MO mo1 = new MO();
		mo1.setMobile("18287131061");
		mo1.setMessage("测试上行短信1");
		mo1.setReceiveTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(System.currentTimeMillis())));
		mo1.setExtendCode("131061");
		mo1.setMsgID(UUID.randomUUID().toString().substring(0, 10));
		String moString = XmlBeanUtils.bean2Xml(moMap, mo1);
		builder.append(moString+ "\n");
		MO mo2 = new MO();
		mo2.setMobile("18287131062");
		mo2.setMessage("测试上行短信2");
		mo2.setReceiveTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date(System.currentTimeMillis())));
		mo2.setExtendCode("131062");
		mo2.setMsgID(UUID.randomUUID().toString().substring(0, 10));
		moString = XmlBeanUtils.bean2Xml(moMap, mo2);
		builder.append(moString+ "\n");
		//
		builder.append(responseEndString);
		return URLEncoder.encode(builder.toString(), "utf-8");
	}

	private String createReportText() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		builder.append(xmlHead + "\n");
		builder.append(responseStartString+ "\n");
		//
		Map<String, Class<?>> reportMap = new HashMap<String, Class<?>>();
		reportMap.put(reportString, Report.class);
		//
		Report report1 = new Report();
		report1.setMobile("18287131061");
		report1.setMsgID(UUID.randomUUID().toString().substring(0, 10));
		report1.setStatus("DELIVRD");
		String repoString = XmlBeanUtils.bean2Xml(reportMap, report1);
		builder.append(repoString+ "\n");
		Report report2 = new Report();
		report2.setMobile("18287131062");
		report2.setMsgID(UUID.randomUUID().toString().substring(0, 10));
		report2.setStatus("DELIVRD");
		repoString = XmlBeanUtils.bean2Xml(reportMap, report2);
		builder.append(repoString+ "\n");
		//
		builder.append(responseEndString);
		return URLEncoder.encode(builder.toString(), "utf-8");
	}

}
