package com.company.bma.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static String asJsonString(final Object obj) {
		try {
			System.out.println("test build");
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
