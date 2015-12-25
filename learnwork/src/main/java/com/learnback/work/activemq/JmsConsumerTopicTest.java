package com.learnback.work.activemq;

import javax.jms.JMSException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JmsConsumerTopicTest {

	private JmsConsumer consumer = null;

	@Before
	public void before() throws JMSException, Exception {
		consumer = new JmsConsumer("topic");
	}

	@Test
	public void testConsumer() throws JMSException, Exception {
		while (true) { //等待接收消息

		}
	}

	@After
	public void after() throws JMSException {
		consumer.close();
	}

}
