package com.jade.swp.util;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jade.swp.controller.BoardController;

public class ApacheCommonTest {
	private static final Logger logger = LoggerFactory.getLogger(ApacheCommonTest.class);
	
	private String[] strs = new String[] {"aaa", "bbb"};
	
	private String[][] person = new String[][] {
		{"chan", "faithful"},
		{"sanga", "pretty"},
		{"jungsu", "good"},
		{"kyungmin", "smart"}
	};
	
	private int[] nums = new int[] {2, 3, 7, 6, 8};
	
	private Date today = new Date();
	
	@Test
	public void testRSUtils() {
		System.out.println(RandomStringUtils.randomAlphanumeric(5));
		System.out.println(RandomStringUtils.randomAlphabetic(5));
		System.out.println(RandomStringUtils.randomNumeric(5));
		
		String s = "aaa,bbb,ccc";
//		String s = null; // ""
		String[] ss = StringUtils.isNotEmpty(s) ? s.split(",") : null;
		String[] ss2 = StringUtils.split(s);
		System.out.println(Arrays.toString(ss) + ", " + Arrays.toString(ss2));
	}
	
	@Ignore @Test
	public void testNumberUtils() {
		int min = NumberUtils.min(nums);
		int max = NumberUtils.max(nums);
		System.out.println(min + " :  " + max);
		
		String nstr = "1234";
		String nullstr = null;
		if (StringUtils.isNumeric(strs[0]))
			System.out.println("createNumber: " + NumberUtils.createNumber(strs[0]));
		
		System.out.println("createNumber: " + NumberUtils.createNumber(nstr));
		System.out.println("null:" + NumberUtils.toInt(nullstr, 9));
	}
			
	@Ignore @Test
	public void testDateUtils() {
		Date yesterday = DateUtils.addDays(today, -1);
		Date tomorrow = DateUtils.addDays(today, 1);
		Date nextYear = DateUtils.addYears(today, 1);
		
		//logger.info("y={},t={},ny={}", yesterday, tomorrow, nextYear);
		System.out.println("y=" + yesterday);
		System.out.println("t=" + tomorrow);
		System.out.println("ny=" + nextYear);
		
		System.out.println("isSameDay: " + DateUtils.isSameDay(today, new Date()));
	}

	@Ignore @Test
	public void testArrayUtils() {
		System.out.println(Arrays.toString(person));
		System.out.println(Arrays.toString(strs));
		System.out.println(ArrayUtils.toString(strs));
		System.out.println(ArrayUtils.toString(person));
		
		Map<Object, Object> map = ArrayUtils.toMap(person);
		System.out.println("Chan is " + map.get("chan"));
		
		System.out.println(Arrays.toString(nums));
		System.out.println("len=" + nums.length);
		Arrays.sort(nums);
		System.out.println("Sort: " + ArrayUtils.toString(nums));
		ArrayUtils.reverse(nums);
		System.out.println("ints: " + Arrays.toString(nums));
		System.out.println("contains: " + ArrayUtils.contains(nums, 9));
		System.out.println("contains: " + ArrayUtils.contains(nums, 8));
	}
	

}
