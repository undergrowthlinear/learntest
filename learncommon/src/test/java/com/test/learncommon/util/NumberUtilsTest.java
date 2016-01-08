package com.test.learncommon.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的NumberUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class NumberUtilsTest {

	int numOne=10,numTwo=20;
	
	@Before
	public void before() {
	}
	
	@Test
	public void testNumber(){
		System.out.println(NumberUtils.min(numOne,numTwo));
		System.out.println(NumberUtils.max(numOne,numTwo));
		System.out.println(NumberUtils.compare(numOne, numTwo));
		System.out.println(NumberUtils.isDigits("iu"));
		System.out.println(NumberUtils.isDigits("12"));
	}

}
