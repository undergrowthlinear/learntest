package com.test.learncommon.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

import com.test.learncommon.util.entity.Person;

/**
 * 
 * @Description: TODO(测试common-codec)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class CodeCTest {

	Person person = null;

	@Before
	public void testBefore() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Class class1 = Class.forName("com.learncommon.util.test.entity.Person");
		person = (Person) class1.newInstance();
		setPersonValue(person);
	}

	/**
	 * 初始化bean
	 * 
	 * @param person
	 */
	private void setPersonValue(Person person) {
		// TODO Auto-generated method stub
		person.setId(UUID.randomUUID().toString());
		person.setName("阿三");
		person.setSex("非人类");
		person.setBirthday(new Date(System.currentTimeMillis()));
		person.setRemark("测试org.apache.commons.beanutils.BeanUtils");
	}

	/**
	 * 编解码
	 * 
	 * @throws EncoderException
	 */
	@Test
	public void testEncodeDecode() throws EncoderException {
		Base64 beBase64 = new Base64();
		byte[] remarkByte = person.getRemark().getBytes(
				Charset.forName("UTF-8"));
		String remarkBase64 = beBase64.encodeAsString(remarkByte);
		System.out.println("编码-->" + person.getRemark() + ":" + remarkByte
				+ ":" + remarkBase64);
		System.out.println("解码-->"
				+ person.getRemark()
				+ ":"
				+ remarkByte
				+ ":"
				+ new String(beBase64.decode(remarkBase64), Charset
						.forName("UTF-8")));
	}
}
