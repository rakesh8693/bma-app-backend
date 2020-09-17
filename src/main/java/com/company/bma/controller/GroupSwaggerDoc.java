package com.company.bma.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.company.bma.model.Card;
import com.company.bma.model.GenericResponse;
import com.company.bma.model.GroupCategory;
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

	@Operation(tags = "GroupController", summary = "Add Card To Group", description = "This api is used to add card to group", parameters = {
			@Parameter(name = "id", description = "Card Id", required = true, in = ParameterIn.PATH) }, requestBody = @RequestBody(description = "Group request body", required = true, content = @Content(schema = @Schema(implementation = GroupRequest.class))), responses = {
					@ApiResponse(description = "Successful operation", responseCode = "204"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> addCardToGroup(Integer id, GroupRequest groupRequest);

	@Operation(tags = "GroupController", summary = "Retrieve Card by Group Category And Name", description = "This api is used to retrieve cards of groups", parameters = {
			@Parameter(name = "groupCategory", description = "Categories of group", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = Card.class))),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<List<Card>> retrieveCardByGroup(GroupCategory groupCategory, String groupName);

	@Operation(tags = "GroupController", summary = "Retrieve Group Names", description = "This api is used to retrieve groupName based on groupType.", parameters = {
			@Parameter(name = "groupCategory", description = "Categories of group", required = true, in = ParameterIn.PATH) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<List<String>> retrieveGroupName(GroupCategory groupCategory);

	@Operation(tags = "GroupController", summary = "Export Cards", description = "This api is used to export cards", parameters = {
			@Parameter(name = "groupCategory", description = "Categories of group", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	void exportCards(GroupCategory groupCategory, String groupName, HttpServletResponse response);

	@Operation(tags = "GroupController", summary = "Import Cards", description = "This api is used to import cards", parameters = {
			@Parameter(name = "groupCategory", description = "Categories", required = true, in = ParameterIn.PATH),
			@Parameter(name = "groupName", description = "Group Name", required = true, in = ParameterIn.PATH) }, requestBody = @RequestBody(description = "file", required = true, content = @Content(schema = @Schema(implementation = MultipartFile.class))), responses = {
					@ApiResponse(description = "Successful operation", responseCode = "200"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	public ResponseEntity<Void> importCards(GroupCategory groupCategory, String groupName, MultipartFile file);

}
