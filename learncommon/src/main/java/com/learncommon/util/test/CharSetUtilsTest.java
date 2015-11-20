package com.learncommon.util.test;

import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的CharSet进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class CharSetUtilsTest {

	String str = null;

	@Before
	public void beforeTest() {
		str = "the day is not good , but i must more hard";
	}

	@Test
	public void testCharSet() {
		CharSet charSet = CharSet.getInstance("a-zA-Z");
		System.out.println(charSet.contains('a'));
	}

	@Test
	public void testCharSets() {
		System.out.println("统计字符个数:" + CharSetUtils.count(str, "a-b"));
		System.out.println("删除字符:" + CharSetUtils.delete(str, "a-b"));
		System.out.println("保留字符:" + CharSetUtils.keep(str, "a-b"));
		System.out.println("去除重复字符:" + CharSetUtils.squeeze(str, "a-o"));
	}

}
