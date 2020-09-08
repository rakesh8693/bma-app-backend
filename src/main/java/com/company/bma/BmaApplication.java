package com.company.bma;


import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class,ManagementWebSecurityAutoConfiguration.class})
@OpenAPIDefinition(info=@Info(title = "BMA API",version="1.0",description="BookMark Management Application."))
public class BmaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BmaApplication.class).properties("spring.config.name:bma-config").build().run(args);
	}

}
