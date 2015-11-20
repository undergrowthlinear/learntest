package com.learncommon.util.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的DateFormatUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class DateFormatUtilsTest {

	@Before
	public void before() {
	}

	@Test
	public void testDateFormatUtil() {
		System.out.println(DateFormatUtils.format(System.currentTimeMillis(),
				"yyyy-MM-dd"));
		System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(System
				.currentTimeMillis()));
		System.out.println(DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(System
				.currentTimeMillis()));
		System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(System
				.currentTimeMillis()));
		System.out.println(DateFormatUtils.format(System.currentTimeMillis(),
				"yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateFormatUtils.SMTP_DATETIME_FORMAT.format(System
				.currentTimeMillis()));

	}
}
