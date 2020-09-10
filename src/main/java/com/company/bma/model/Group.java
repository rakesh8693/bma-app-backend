/*
 * Swagger BookMark Mangement Application
 * This is a BookMark Management Application.   You can create short url of your bookmark and you can manage bookmark by various groups. 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: rakesh8693@gmail.com
 *
 *
 */

package com.company.bma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Entity
@Table(name="GROUPMANAGER")
public class Group {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "groupid")
	@Schema(hidden = true)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "GROUPCATEGORY")
	private GroupCategory groupCategory;

	private String groupname;
}
