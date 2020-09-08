package com.company.bma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoleType {
	ADMIN(100), USER(101);
	@Getter
	private Integer value;
}
