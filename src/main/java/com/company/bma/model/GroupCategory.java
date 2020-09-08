package com.company.bma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum GroupCategory {
	TRIBE(1001), FEATURE_TEAM(1002), APPLICATION(1003), PLATFORMS(1004);

	@Getter
	private Integer value;
}
