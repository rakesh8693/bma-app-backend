/*
 * Swagger BookMark Mangement Application
 * This is a BookMark Management Application.   You can create short url of your bookmark and you can manage bookmark by various groups. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rakesh8693@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.company.bma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Card
 */
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cardid")
	private Integer id;
	@NonNull
	private String title;
	@NonNull
	private String description;
	@NonNull
	private String icon;
	@NonNull
	private Integer validate;
	
	/*
	 * @OneToOne(mappedBy = "card") private ShortUrl shortUrl;
	 * 
	 * //cascade = CascadeType.ALL, //fetch = FetchType.LAZY
	 */}
