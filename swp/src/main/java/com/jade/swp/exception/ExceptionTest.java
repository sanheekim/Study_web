package com.jade.swp.exception;

import java.util.HashMap;
import java.util.Map;

public class ExceptionTest {
	private static Map<Integer, String> map = new HashMap<>();

	public static void main(String[] args) {
		int k = -1;
		try {
			create(k);
		} catch (DuplicatedException e) {
			
		} catch (Exception e) {
			System.err.println("Unknown Exception:" + e.getMessage());
			k++;
			try {
				create(k);
				create(k);
			} catch (DuplicatedException e1) {
				k++;
				try {
					create(k);
				} catch (Exception eee) {
					e1.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println("Map:" + map);
	}

	private static void create(Integer i) throws DuplicatedException, Exception {
		if (map.containsKey(i)) {
			throw new DuplicatedException(i);
		} else if (i < 0) {
			throw new Exception("Under Zero!!");
		}
		map.put(i, "str" + i);
	}

}
