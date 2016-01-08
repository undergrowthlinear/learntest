package com.test.learncommon.util;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的HashCodeUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class HashCodeUtilsTest {

	@Before
	public void before() {
	}

	@Test
	public void testHashCodeUtils() {
		System.out.println(HashCodeBuilder.reflectionHashCode(
				Integer.valueOf(17), true));
		;
	}

}
