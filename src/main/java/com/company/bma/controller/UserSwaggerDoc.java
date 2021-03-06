package com.company.bma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.bma.model.GenericResponse;
import com.company.bma.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


public interface UserSwaggerDoc {

	@Operation(tags = "UserController", summary = "Create User", description = "This api is used to create user", requestBody = @RequestBody(description = "User request body", required = true, content = @Content(schema = @Schema(implementation = User.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "201"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> createUser(User user);

	@Operation(tags = "UserController", summary = "Retrieve Users", description = "This api is used to retrieve users", responses = {
			@ApiResponse(description = "Successful operation", responseCode = "200", content = @Content(schema = @Schema(implementation = User.class))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })

	ResponseEntity<List<User>> retrieveUsers();

	@Operation(tags = "UserController", summary = "Update User", description = "This api is used to update user", parameters = @Parameter(name = "id", description = "User Id", required = true, in = ParameterIn.PATH), requestBody = @RequestBody(description = "User request body", required = true, content = @Content(schema = @Schema(implementation = User.class))), responses = {
			@ApiResponse(description = "Successful operation", responseCode = "204"),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })

	ResponseEntity<Void> updateUser(Integer id, User user);

	@Operation(tags = "UserController", summary = "Delete User", description = "This api is used to delete user", parameters = {
			@Parameter(name = "id", description = "User Id", required = true, in = ParameterIn.PATH), }, responses = {
					@ApiResponse(description = "Successful operation", responseCode = "202"),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
					@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<Void> deleteUserById(Integer id);

	@Operation(tags = "UserController", summary = "userLogin", description = "This api is used for userLogin",parameters = {
			@Parameter(name = "userName", description = "UserName", required = true, in = ParameterIn.QUERY),
			@Parameter(name = "password", description = "password", required = true, in = ParameterIn.QUERY)}, responses = {
			@ApiResponse(description = "Successful operation", responseCode = "200",content = @Content(schema = @Schema(implementation = User.class))),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "Forbidden", responseCode = "403", content = @Content(schema = @Schema(implementation = GenericResponse.class))),
			@ApiResponse(description = "ResourceNotFound", responseCode = "404", content = @Content(schema = @Schema(implementation = GenericResponse.class))) })
	ResponseEntity<User> userLogin(String userName,String password);

}
