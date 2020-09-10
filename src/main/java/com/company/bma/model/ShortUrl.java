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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class ShortUrl {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "surlid")
	private Integer id;

	@Lob
	@NonNull
	@Column(name = "longurl")
	private String lurl;

	@NonNull
	@Column(name = "shorturl")
	private String surl;

	@NonNull
	@Column(name = "dateofexpiry")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
}
