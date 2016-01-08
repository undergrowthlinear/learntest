package com.test.learncommon.util;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的SystemUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class SystemUtilsTest {


	@Before
	public void before() {
	}
	
	@Test
	public void testSystemUtil(){
		System.out.println(SystemUtils.FILE_ENCODING);
		System.out.println(SystemUtils.FILE_SEPARATOR);
		System.out.println(SystemUtils.JAVA_CLASS_PATH);
		System.out.println(SystemUtils.JAVA_CLASS_VERSION);
		System.out.println(SystemUtils.JAVA_COMPILER);
		System.out.println(SystemUtils.JAVA_VENDOR);
		System.out.println(SystemUtils.JAVA_VENDOR_URL);
		System.out.println(SystemUtils.JAVA_HOME);
		System.out.println(SystemUtils.JAVA_VM_INFO);
		System.out.println(SystemUtils.JAVA_VM_NAME);
		System.out.println(SystemUtils.JAVA_VM_SPECIFICATION_NAME);
		System.out.println(SystemUtils.JAVA_VM_SPECIFICATION_VENDOR);
		System.out.println(SystemUtils.LINE_SEPARATOR);
		System.out.println(SystemUtils.OS_NAME);
		System.out.println(SystemUtils.OS_VERSION);
	}

}
