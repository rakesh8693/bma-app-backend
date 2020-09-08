package com.company.bma;

import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class})
class BmaApplicationTests {

	
	void contextLoads() {
	}

}
