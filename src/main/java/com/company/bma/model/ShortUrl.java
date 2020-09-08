/*
 * Swagger BookMark Mangement Application
 * This is a BookMark Management Application.   You can create short url of your bookmark and you can manage bookmark by various groups. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rakesh8693@gmail.com
 *
 */

package com.company.bma.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ShortUrl {
	private Long id;

	private String lurl;

	private String surl;

	private Date expiryDate;
}
