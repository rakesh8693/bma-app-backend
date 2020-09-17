package com.company.bma.utils;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.exception.Generic406Exception;

public class ExceptionUtils {
	
	public static Generic404Exception generic404Exception(String description) {
		Generic404Exception generic404Exception = new Generic404Exception("Not_Found",description);
		return generic404Exception;
	}
	
	public static Generic406Exception generic406Exception(String description) {
		Generic406Exception generic406Exception = new Generic406Exception("Not_ACCEPTABLE",description);
		return generic406Exception;
	}
}
