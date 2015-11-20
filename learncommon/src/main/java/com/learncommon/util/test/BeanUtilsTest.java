package com.learncommon.util.test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.jaxws.description.builder.converter.ConverterUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Before;
import org.junit.Test;

import com.learncommon.util.test.entity.Person;

/**
 * 
 * @Description: TODO(测试BeanUtils)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月18日
 * @Version 1.0.0
 */
public class BeanUtilsTest {

	Person person = null;

	@Before
	public void testBefore() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		Class class1 = Class.forName("com.learncommon.util.test.entity.Person");
		person = (Person) class1.newInstance();
		setPersonValue(person);
	}

	/**
	 * 修改、获取属性
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testSetGetProperties() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		System.out.println(person);
		BeanUtils.setProperty(person, "name", "测试");
		System.out.println(BeanUtils.getProperty(person, "name"));
		System.out.println(person);
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
	 * 自定义转换器
	 * 
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test
	public void testDateConvert() throws IllegalAccessException,
			InvocationTargetException {
		System.out.println(person);
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(person, "birthday", "1989-01-02");
		System.out.println(person);
	}

	@Test
	public void testCustomDateConvert() throws IllegalAccessException,
			InvocationTargetException {
		System.out.println(person);
		ConvertUtils.register(new Converter() {

			@Override
			public <T> T convert(Class<T> type, Object value) {
				// TODO Auto-generated method stub
				if (value == null)
					return null;
				SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				try {
					return (T) format.parse((String) value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}, Date.class);
		BeanUtils.setProperty(person, "birthday", "1989-01-02");
		System.out.println(person);
	}

	/**
	 * 复制bean
	 * 
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testCloneBean() throws IllegalAccessException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {
		System.out.println(person);
		Person personClone = (Person) BeanUtils.cloneBean(person);
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.setProperty(personClone, "birthday", "1989-01-02");
		System.out.println(personClone);
	}

	/**
	 * 转换Map-->Bean
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	@Test
	public void testPushPull() throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		System.out.println(person);
		Map<String, String> perMap = BeanUtils.describe(person);
		for (Map.Entry<String, String> entry : perMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			if (entry.getKey().contains("sex"))
				entry.setValue("外星人");
		}
		System.out.println("===============================");
		ConvertUtils.register(new Converter() {

			@Override
			public <T> T convert(Class<T> type, Object value) {
				// TODO Auto-generated method stub
				if (value == null)
					return null;
				SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
				try {
					return (T) format.parse((String) value);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		}, Date.class);
		BeanUtils.populate(person, perMap);
		System.out.println(person);
	}
}
