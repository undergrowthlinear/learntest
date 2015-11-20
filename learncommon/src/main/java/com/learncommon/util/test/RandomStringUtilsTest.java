package com.learncommon.util.test;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的RandomStringUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class RandomStringUtilsTest {


	@Before
	public void before() {
	}

	
	@Test
	public void testRandom(){
		System.out.println(RandomStringUtils.random(15,true,true));
		System.out.println(RandomStringUtils.random(15,"ab"));
		System.out.println(RandomStringUtils.random(15,'a','b'));
	}
	
}
