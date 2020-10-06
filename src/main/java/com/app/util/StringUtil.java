package com.app.util;

public class StringUtil {

	private static final String NULL_VALUE = "NULL";

	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	// 正确的数据
	// 不包括空值 空字符串 和"NULL" 值
	public static boolean isRightValue(String str) {
		if (isBlank(str)) {
			return false;
		}
		if (NULL_VALUE.equalsIgnoreCase(str.trim())) {
			return false;
		}
		return true;
	}

}
