/*
 * Swagger BookMark Mangement Application
 * This is a BookMark Management Application.   You can create short url of your bookmark and you can manage bookmark by various groups. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rakesh8693@gmail.com
 *
 *
 */

package com.company.bma.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Generic401Exception extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	private String description;
}
