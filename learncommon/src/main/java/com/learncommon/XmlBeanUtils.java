package com.learncommon;

import java.util.Map;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * @Description: TODO(Xml与Bean的转换类)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年10月29日
 * @Version 1.0.0
 */
public class XmlBeanUtils {

	// 默认对象
	private final static XStream DEFAULT_XSTREAM = new XStream();

	/**
	 * 将bean转为xml
	 * 
	 * @param bean
	 * @return
	 */
	public static String bean2Xml(Object bean) {
		return DEFAULT_XSTREAM.toXML(bean);
	}

	/**
	 * 将bean转为xml
	 * 
	 * @param clazzMap
	 * @param bean
	 * @return
	 */
	public static String bean2Xml(Map<String, Class<?>> clazzMap, Object bean) {
		XStream xStream = getXStream(clazzMap);
		return xStream.toXML(bean);
	}

	@SuppressWarnings("unchecked")
	public static <T> T xml2bean(String xml) {
		return (T) DEFAULT_XSTREAM.fromXML(xml);
	}

	@SuppressWarnings("unchecked")
	public static <T> T xml2bean(Map<String, Class<?>> clazzMap, String xml) {
		XStream xStream = getXStream(clazzMap);
		return (T) xStream.fromXML(xml);
	}

	/**
	 * 添加bean的简称
	 * 
	 * @param clazzMap
	 * @return
	 */
	private static XStream getXStream(Map<String, Class<?>> clazzMap) {
		// TODO Auto-generated method stub
		XStream xStream = new XStream();
		for (Map.Entry<String, Class<?>> nameEnry : clazzMap.entrySet()) {
			xStream.alias(nameEnry.getKey(), nameEnry.getValue());
		}
		return xStream;
	}

}
