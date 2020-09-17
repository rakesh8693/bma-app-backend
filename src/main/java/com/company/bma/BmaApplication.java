package com.company.bma;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableWebSecurity
@OpenAPIDefinition(info = @Info(title = "BMA API", version = "1.0", description = "BookMark Management Application."))
public class BmaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(BmaApplication.class).properties("spring.config.name:bma-config").build()
				.run(args);
	}

}
