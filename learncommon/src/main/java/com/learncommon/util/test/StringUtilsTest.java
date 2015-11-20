package com.learncommon.util.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @Description: TODO(针对commons-lang3 的StringUtils进行测试)
 * @Author <a href="zhangwu@wxchina.com">Wu.Zhang</a>
 * @Date 2015年11月19日
 * @Version 1.0.0
 */
public class StringUtilsTest {

	String strOne = null, strTwo = null;

	@Before
	public void before() {
		strOne = "the day is not good ";
		strTwo = "but i must more hard";
	}

	/**
	 * <ul>
	 * <li><b>IsEmpty/IsBlank</b> - checks if a String contains text</li>
	 * <li><b>Equals</b> - compares two strings null-safe</li>
	 * <li><b>startsWith</b> - check if a String starts with a prefix null-safe</li>
	 * <li><b>endsWith</b> - check if a String ends with a suffix null-safe</li>
	 * <li><b>IndexOf/LastIndexOf/Contains</b> - null-safe index-of checks
	 * <li><b>IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut</b> -
	 * index-of any of a set of Strings</li>
	 * <li><b>ContainsOnly/ContainsNone/ContainsAny</b> - does String contains
	 * only/none/any of these characters</li>
	 * <li><b>Chomp/Chop</b> - removes the last part of a String</li>
	 * <li><b>UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize</b> - changes
	 * the case of a String</li>
	 * <li><b>CountMatches</b> - counts the number of occurrences of one String
	 * in another</li>
	 * <li><b>DefaultString</b> - protects against a null input String</li>
	 * <li><b>Reverse/ReverseDelimited</b> - reverses a String</li>
	 * <li><b>Abbreviate</b> - abbreviates a string using ellipsis</li>
	 * <li><b>Difference</b> - compares Strings and reports on their differences
	 * </li>
	 * <li><b>LevenshteinDistance</b> - the number of changes needed to change
	 * one String into another</li>
	 * </ul>
	 */
	@Test
	public void testEmptyBlankStringUtils() {
		String[] array = new String[2];
		array[0] = StringUtils.repeat('*', 10) + strOne
				+ StringUtils.repeat('*', 10);
		array[1] = StringUtils.repeat('~', 10) + strTwo
				+ StringUtils.repeat('~', 10);
		System.out.println(StringUtils.join(array, ","));
		System.out.println("判断是否为空或者空格");
		System.out.println("empty:" + StringUtils.isEmpty(strOne) + "\t"
				+ StringUtils.isEmpty(null) + "\t" + StringUtils.isEmpty("")
				+ "\t" + StringUtils.isEmpty(" "));
		System.out.println("whitespace:" + StringUtils.isBlank(strOne) + "\t"
				+ StringUtils.isBlank(null) + "\t" + StringUtils.isBlank("")
				+ "\t" + StringUtils.isBlank(" "));
	}

	/**
	 * * <li><b>Split/Join</b> - splits a String into an array of substrings and
	 * vice versa</li>
	 */
	@Test
	public void testJoinSplitRepeatStringUtils() {
		String[] array = new String[2];
		array[0] = StringUtils.repeat('*', 10) + strOne
				+ StringUtils.repeat('*', 10);
		array[1] = StringUtils.repeat('~', 10) + strTwo
				+ StringUtils.repeat('~', 10);
		String joinStr = StringUtils.join(array, ",");
		System.out.println(joinStr);
		for (String string : joinStr.split(",")) {
			System.out.println(string);
		}
	}

	/**
	 * * <li><b>Trim/Strip</b> - removes leading and trailing whitespace</li>
	 * Strip-->Strips any of a set of characters from the start and end of a
	 * String
	 */
	@Test
	public void testTrimStripStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.trim("    " + strOne + "    ").length());
		System.out
				.println(StringUtils.strip("    " + strOne + "    ").length());
		System.out.println(StringUtils.strip("zabcyx", "xyz"));
	}

	/**
	 * * <li><b>Replace/Overlay</b> - Searches a String and replaces one String
	 * with another</li>
	 * <p>
	 * Replaces all occurrences of a String within another String.
	 * </p>
	 * <p>
	 * Overlays part of a String with another String.
	 * </p>
	 */
	@Test
	public void testReplaceOverlayStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.replace(strOne, "day", "month"));
		System.out.println(StringUtils.overlay(strOne, "dd", 4, 7));
	}

	/**
	 * * <li><b>Remove/Delete</b> - removes part of a String</li>.
	 * <p>
	 * Removes all occurrences of a character from within the source string.
	 * </p>
	 * <p>
	 * Deletes all whitespaces from a String as defined by
	 */
	@Test
	public void testRemoveDeleteStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.remove(strOne, 'd'));
		System.out.println(StringUtils.deleteWhitespace("    " + strOne
				+ "    "));
	}

	/**
	 * * <li><b>AppendIfMissing</b> - appends a suffix to the end of the String
	 * if not present</li> * Appends the suffix to the end of the string if the
	 * string does not already end with any the suffixes. <li>
	 * <b>PrependIfMissing</b> - prepends a prefix to the start of the String if
	 * not present</li> * Prepends the prefix to the start of the string if the
	 * string does not already start with any of the prefixes.
	 * 
	 * <li><b>LeftPad/RightPad/Center/Repeat</b> - pads a String</li>
	 * <p>
	 * Left pad a String with a specified String.
	 * </p>
	 */
	@Test
	public void testAppendPrependLeftPadCenterStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.appendIfMissing(strOne, "undergrowth",
				"csdn"));
		System.out.println(StringUtils.appendIfMissing(strOne, "undergrowth",
				" "));
		System.out.println(StringUtils.prependIfMissing(strOne, "undergrowth ",
				"csdn"));
		System.out.println(StringUtils.prependIfMissing(strOne, "undergrowth ",
				"the"));
		System.out.println(StringUtils.leftPad(strOne, 25, ""));
		System.out.println(StringUtils.leftPad(strOne, 26, "who"));
		System.out.println(StringUtils.rightPad(strOne, 25, ""));
		System.out.println(StringUtils.rightPad(strOne, 26, "who"));
		System.out.println(StringUtils.center(strOne, 100, '*'));
		System.out.println(StringUtils.center(strOne, 100, "*!"));
		System.out.println(StringUtils.repeat(strOne, 2));
		System.out.println(StringUtils.repeat(strOne, ",", 2));
	}

	/**
	 * * <li><b>IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable</b> - checks the
	 * characters in a String</li>
	 */
	@Test
	public void testIsAlphaIsNumericIsWhitespaceIsAsciiPrintableStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.isAlpha(strOne));
		System.out.println(StringUtils.isNumeric(strOne));
		System.out.println(StringUtils.isWhitespace(strOne));
		System.out.println(StringUtils.isAsciiPrintable(strOne));
	}

	/**
	 * * <li><b>Substring/Left/Right/Mid</b> - null-safe substring extractions</li>
	 * <li><b>SubstringBefore/SubstringAfter/SubstringBetween</b> - substring
	 * extraction relative to other strings</li>
	 */
	@Test
	public void testSubstringLeftStringUtils() {
		System.out.println(strOne + ":" + strOne.length());
		System.out.println(StringUtils.substring(strOne, 3));
		System.out.println(StringUtils.substring(strOne, 3, 7));
		System.out.println(StringUtils.substringAfter(strOne, " "));
		System.out.println(StringUtils.substringAfterLast(strOne, " "));
		System.out.println(StringUtils.substringBefore(strOne, " "));
		System.out.println(StringUtils.substringBeforeLast(strOne, " "));
		System.out.println(StringUtils.substringBetween(strOne, "the", "not"));

	}

}
