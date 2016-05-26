package com.learnback.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class EncodeDeCode {

	@Test
	public void testEncodeDecode() throws UnsupportedEncodingException{
		String content="%D6%D0";
		System.out.println(content);
		String conetntEncoString1=URLEncoder.encode(content, "gb2312");
		System.out.println(conetntEncoString1);
		String conetntEncoString2=URLEncoder.encode(conetntEncoString1, "gb2312");
		System.out.println(conetntEncoString2);
		//
		String conetntDecoString1=URLDecoder.decode(conetntEncoString1, "gb2312");
		System.out.println("解码:"+conetntDecoString1);
		 conetntDecoString1=URLDecoder.decode(conetntDecoString1, "gb2312");
		System.out.println(conetntDecoString1);
		//
		String conetntDecoString2=URLDecoder.decode(conetntEncoString1, "gb2312");
		System.out.println(conetntDecoString2);
		conetntDecoString2=URLDecoder.decode(conetntDecoString2, "gb2312");
		System.out.println(conetntDecoString2);
		conetntDecoString2=URLDecoder.decode(conetntDecoString2, "gb2312");
		System.out.println(conetntDecoString2);
	}
	
}
