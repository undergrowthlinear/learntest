package com.learncommon.util.test;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的ObjectUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class ObjectUtilsTest {

	int c1 = 10, c2 = 20;

	@Before
	public void before() {
	}

	@Test
	public void testObject() {
		System.out.println(ObjectUtils.compare(c1, c2));
		System.out.println(ObjectUtils.identityToString(Integer.valueOf(c1)));
		System.out.println(ObjectUtils.hashCode(Integer.valueOf(c1)));
		System.out.println(ObjectUtils.equals(Integer.valueOf(c1),
				Integer.valueOf(c1)));
	}
}
