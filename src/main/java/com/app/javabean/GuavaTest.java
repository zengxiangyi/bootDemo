package com.app.javabean;

import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GuavaTest {

	public static void main(String[] args) {
		splitter();
		withMapTest();
		splitterListTest();
	}

	public static void testArray() {
		List<String> lists = Lists.newArrayList("a", "b", "g", null, "8", "9");
		
	}
	
	
	public static void splitter() {
		List<String> lists = Lists.newArrayList("a", "b", "g",null, "8", "9");
		String result = Joiner.on(",").skipNulls().join(lists);
		System.out.println(result);
	}
	public static void splitterListTest() {
        String test = " 34344, 34, 34,哈哈  ";
        List<String> lists = Splitter.on(",").omitEmptyStrings().splitToList(test);
        System.out.println(lists);
    }

	public static void fixedLengthTest() {
        String test = "343443434哈哈";
        List<String> lists = Splitter.fixedLength(3).splitToList(test);
        System.out.println(lists);
    }
	
	public static void withMapTest() {
        Map<Integer, String> maps = Maps.newHashMap();
        maps.put(1, "哈哈");
        maps.put(2, "压压");
        String result = Joiner.on(",").withKeyValueSeparator(":").join(maps);
        System.out.println(result);
        System.out.println(maps);
    }
}
