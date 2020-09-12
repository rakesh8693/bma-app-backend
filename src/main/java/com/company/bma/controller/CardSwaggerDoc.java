package com.company.bma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;
import com.company.bma.model.GenericResponse;
import com.company.bma.model.GroupCategory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface CardSwaggerDoc {
	@Operation(tags = "CardController", summary = "Create Card", description = "This api is used to create card", parameters = @Parameter(name = "id", description = "User Id", required = true, in = ParameterIn.PATH), requestBody = @RequestBody(description = "card request body", required = true, content = @Content(schema = @Schema(implementation = CardRequest.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "201"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> createCard(Integer id, CardRequest card);

	@Operation(tags = "CardController", summary = "Retrieve Card", description = "This api is used to retrieve card", parameters = @Parameter(name = "id", description = "User Id", required = true, in = ParameterIn.PATH), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = Card.class))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<List<Card>> retrieveCard(Integer id);

	@Operation(tags = "CardController", summary = "Update Card", description = "This api is used to update card", parameters = @Parameter(name = "id", description = "Card Id", required = true, in = ParameterIn.PATH), requestBody = @RequestBody(description = "card request body", required = true, content = @Content(schema = @Schema(implementation = CardRequest.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "204"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> updateCard(Integer id, CardRequest card);

	@Operation(tags = "CardController", summary = "Delete Card", description = "This api is used to delete card", parameters = {
			@Parameter(name = "id", description = "Card Id", required = true, in = ParameterIn.PATH), }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "202"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> deleteCard(Integer id);

	@Operation(tags = "CardController", summary = "Cards To Validate", description = "This api is used to validate cards", parameters = {
			@Parameter(name = "id", description = "User Id", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupCategory", description = "Categories of group", required = true, in = ParameterIn.QUERY),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.QUERY) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = Card.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	public ResponseEntity<List<Card>> changesToValidate(Integer id, GroupCategory groupCategory, String groupName);

}
