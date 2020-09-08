package com.company.bma.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.company.bma.model.Card;
import com.company.bma.model.GenericResponse;
import com.company.bma.model.Group;
import com.company.bma.model.GroupRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface GroupSwaggerDoc {

	@Operation(tags = "GroupController", summary = "Create Group", description = "This api is used to create group", requestBody = @RequestBody(description = "Group request body", required = true, content = @Content(schema = @Schema(implementation = GroupRequest.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "201"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> createGroup(GroupRequest groupRequest);

	@Operation(tags = "GroupController", summary = "Retrieve Group", description = "This api is used to retrieve group", parameters = {
			@Parameter(name = "groupBy", description = "Categories example value--> TRIBE(1001), FEATURE_TEAM(1002), APPLICATION(1003), PLATFORMS(1004)", required = false, in = ParameterIn.QUERY), }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = Group.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<List<Group>> retrieveGroup(Integer groupBy);

	@Operation(tags = "GroupController", summary = "Export Cards", description = "This api is used to export cards", parameters = {
			@Parameter(name = "groupBy", description = "Categories example value--> TRIBE(1001), FEATURE_TEAM(1002), APPLICATION(1003), PLATFORMS(1004)", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = HttpServletResponse.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<HttpServletResponse> exportCards(@PathVariable Integer groupBy, @PathVariable String groupName);

	@Operation(tags = "GroupController", summary = "Import Cards", description = "This api is used to import cards", parameters = {
			@Parameter(name = "groupBy", description = "Categories example value--> TRIBE(1001), FEATURE_TEAM(1002), APPLICATION(1003), PLATFORMS(1004)", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, requestBody = @RequestBody(description = "file", required = true, content = @Content(schema = @Schema(implementation = MultipartFile.class))), responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	public ResponseEntity<Void> importCards(@PathVariable Integer groupBy, @PathVariable String groupName,
			@RequestParam MultipartFile file);

	@Operation(tags = "GroupController", summary = "Cards To Validate", description = "This api is used to validate cards", parameters = {
			@Parameter(name = "groupBy", description = "Categories example value--> TRIBE(1001), FEATURE_TEAM(1002), APPLICATION(1003), PLATFORMS(1004)", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = Card.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	public ResponseEntity<List<Card>> changesToValidate(@PathVariable Integer groupBy, @PathVariable String groupName);
}
