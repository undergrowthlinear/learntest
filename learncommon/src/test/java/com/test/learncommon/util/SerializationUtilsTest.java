package com.test.learncommon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.junit.Test;

import com.test.learncommon.util.entity.Person;

/**
 * 
 * @Description: TODO(针对commons-lang3 的SerializationUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class SerializationUtilsTest {

	Person person = null;
	OutputStream output = null;
	InputStream input = null;

	@Before
	public void testBefore() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			FileNotFoundException {
		Class class1 = Class.forName("com.learncommon.util.test.entity.Person");
		person = (Person) class1.newInstance();
		setPersonValue(person);
		output = new FileOutputStream("a.txt");
		input = new FileInputStream("a.txt");
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

	@Test
	public void testSerializationUtils() {
		SerializationUtils.serialize(person, output);
		Person person1=SerializationUtils.deserialize(input);
		System.out.println(person1);
	}

}
