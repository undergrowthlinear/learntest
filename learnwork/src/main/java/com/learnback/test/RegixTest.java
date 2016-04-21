package com.learnback.test;

import java.util.regex.Pattern;

public class RegixTest {

private static String vCRegex="^([0-9a-zA-Z!~@#%\\$￥\\^&\\*\\(\\)\\[\\]\\<\\>\\{\\}\\?\\._\\+\\|-]){4,8}$";
	
	
	/**
	 * 
	 * <>?[]{}
	 * 内容，为数字0~9，字母a~z，特殊字符!(感叹号)、~(波浪号)、@(at)、#(井号)、%(百分号)、$(美元符)、￥(元符号)、^(
	 * 次方符)、&(与符号)、*(星号)、((左小括号)、)(右小括号)、.(点)、_(下划线)、+(加号)、|(竖线)、-(减号)、
	 * <(左尖括号)、>(右尖括号)、?(问号)、[(左中括号)、](右中括号)、{(左大括号)、}(右大括号)，长度4-8位。说明：字母不区分大小写，
	 * 特殊字符均为英文状态下输入(￥符号除外)。
	 * 
	 * @param content
	 * @return
	 */
	public static boolean voiceCodeContentLegal(String content) {
		boolean isLegal=Pattern.matches(vCRegex, content);
		return isLegal;
	}
	
	public static void main(String[] args){
		System.out.println("1"+":"+voiceCodeContentLegal("1"));
		System.out.println("12"+":"+voiceCodeContentLegal("12"));
		System.out.println("123"+":"+voiceCodeContentLegal("123"));
		System.out.println("123q"+":"+voiceCodeContentLegal("123q"));
		System.out.println("a$1%!~@#"+":"+voiceCodeContentLegal("a$1%!~@#"));
		System.out.println("a$1%!~@#2"+":"+voiceCodeContentLegal("a$1%!~@#2"));
		System.out.println("￥^&*()"+":"+voiceCodeContentLegal("￥^&*()"));
		System.out.println("￥^&*()._"+":"+voiceCodeContentLegal("￥^&*()._"));
		System.out.println("+|-<>?[]"+":"+voiceCodeContentLegal("+|-<>?[]"));
		System.out.println("{}"+":"+voiceCodeContentLegal("{}"));
		System.out.println("+|-<>?{}"+":"+voiceCodeContentLegal("+|-<>?{}"));
		System.out.println("+|-<>?[]{}"+":"+voiceCodeContentLegal("+|-<>?[]{}"));
		System.out.println("+|-<>?AS"+":"+voiceCodeContentLegal("+|-<>?AS"));
		System.out.println("+|-<>?;"+":"+voiceCodeContentLegal("+|-<>?;"));
		System.out.println("+|-<>?:"+":"+voiceCodeContentLegal("+|-<>?:"));
	}
	
}
