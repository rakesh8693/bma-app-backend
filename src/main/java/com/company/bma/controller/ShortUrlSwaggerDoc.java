package com.company.bma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.bma.model.GenericResponse;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ShortUrlSwaggerDoc {

	@Operation(tags = "ShortUrlController", summary = "Create ShortUrl", description = "This api is used to create shorturl", requestBody = @RequestBody(description = "ShortUrl request body", required = true, content = @Content(schema = @Schema(implementation = ShortUrlRequest.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "201"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> createShortUrl(ShortUrlRequest shortUrlRequest);

	@Operation(tags = "ShortUrlController", summary = "Retrieve ShortUrl", description = "This api is used to retrieve shorturl", parameters = {
			@Parameter(name = "id", description = "ShortUrl Id", required = false, in = ParameterIn.QUERY), }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = ShortUrl.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<List<ShortUrl>> retrieveShortUrl(Integer id);
}
