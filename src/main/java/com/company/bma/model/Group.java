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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name="GROUPMANAGER")
public class Group {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "groupid")
	@Schema(hidden = true)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(name = "GROUPCATEGORY")
	@NonNull
	private GroupCategory groupCategory;

	@NonNull
	@Column(name="GROUPNAME")
	private String groupName;
	
	@Schema(hidden = true)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupid")
	private List<User> users;
	
	@Schema(hidden = true)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "groupid")
	private List<Card> cards;
}
