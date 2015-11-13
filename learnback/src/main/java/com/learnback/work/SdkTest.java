package com.learnback.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.esms.MOMsg;
import com.esms.MessageData;
import com.esms.common.entity.Account;
import com.esms.common.entity.BusinessType;
import com.esms.common.entity.GsmsResponse;
import com.esms.common.entity.MTPack;
import com.esms.common.entity.MTPack.MsgType;
import com.esms.common.entity.MTPack.SendType;
import com.esms.common.entity.MTReport;
import com.esms.common.entity.MTResponse;
import com.esms.common.entity.Ticket;
import com.esms.common.entity.TicketInfo;
import com.learnback.work.entity.PostServer;

/**
 * 支持SOCKET、HTTP、SOCKET4、SOCKET5
 * 
 * @Description: TODO(测试SDK)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月12日
 * @Version 1.0.0
 */
public class SdkTest {

	PostServer postServer = null;
	Account account = null;

	@Before
	public void before() {
		// 获取bean
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring-context.xml");
		postServer = context.getBean("postServer", PostServer.class);
		// 组装发送
		account = new Account(postServer.getUsername(),
				postServer.getPassword());
	}

	@Test
	public void MtSend() {
		// TODO Auto-generated method stub
		MTPack mtPack = createMTPack();
		try {
			GsmsResponse mtResponse = postServer.getPostMsg().post(account,
					mtPack);
			System.out.println(mtResponse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建MTPack
	 * 
	 * @return
	 */
	private static MTPack createMTPack() {
		// TODO Auto-generated method stub
		MTPack mtPack = new MTPack();
		mtPack.setBatchID(UUID.randomUUID());
		mtPack.setBatchName("测试SDK发送" + System.currentTimeMillis());
		mtPack.setMsgType(MsgType.SMS);
		// 默认业务
		mtPack.setBizType(2);
		mtPack.setDistinctFlag(true);
		mtPack.setSendType(SendType.MASS);
		List<MessageData> msgs = createMessageDatas(100);
		mtPack.setMsgs(msgs);
		return mtPack;
	}

	private static List<MessageData> createMessageDatas(int num) {
		// TODO Auto-generated method stub
		List<MessageData> msgs = new ArrayList<MessageData>();
		for (int i = 0; i < num; i++) {
			msgs.add(new MessageData("18287131" + String.format("%03d", i),
					"测试短信内容" + i));
		}
		return msgs;
	}

	@Test
	public void getAccountInfo() {
		try {
			System.out.println(postServer.getPostMsg().getAccountInfo(account));
			;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getBusinessType() {
		try {
			BusinessType[] businessTypes = postServer.getPostMsg().getBizTypes(
					account);
			for (BusinessType businessType : businessTypes) {
				System.out.println(businessType);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getMOMessage() {
		try {
			MOMsg[] moMsgs = postServer.getPostMsg().getMOMsgs(account, 10);
			for (MOMsg moMsg : moMsgs) {
				System.out.println(moMsg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getResponse() {
		try {
			MTResponse[] mtResponses = postServer.getPostMsg().getResps(
					account, 10);
			for (MTResponse mtResponse : mtResponses) {
				System.out.println(mtResponse);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void findReport() {
		try {
			MTReport[] mtReports = postServer.getPostMsg().getReports(account,
					10);
			for (MTReport mtReport : mtReports) {
				System.out.println(mtReport);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void findTickets() {
		try {
			TicketInfo ticketInfo = postServer.getPostMsg().findTickets(
					account, null, null, null, "user01@ent01", 10);
			for (Ticket ticket : ticketInfo.getTickets()) {
				System.out.println(ticket);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
