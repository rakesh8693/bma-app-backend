package com.company.bma.utils;

import com.company.bma.exception.Generic404Exception;

public class ExceptionUtils {
	
	public static Generic404Exception generic404Exception(String description) {
		Generic404Exception generic404Exception = new Generic404Exception("Not_Found",description);
		return generic404Exception;
	}
}
