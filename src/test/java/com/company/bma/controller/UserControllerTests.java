package com.company.bma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.bma.controller.Impl.UserController;
import com.company.bma.model.User;
import com.company.bma.security.CustomAuthenticationProvider;
import com.company.bma.service.UserService;
import com.company.bma.utils.JsonUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource("classpath:application.properties")
public class UserControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@MockBean
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Test
	public void testCreateUserApi() throws Exception {
		mockMvc.perform(post("/user").content(JsonUtils.asJsonString(new User("user", "user@test", "user")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void testUpdateUserApi() throws Exception {
		mockMvc.perform(put("/user/{id}", 1).content(JsonUtils.asJsonString(new User("user", "user@test", "pass")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	@Test
	public void testDeleteUserByIdApi() throws Exception {
		mockMvc.perform(delete("/user/{id}", 1)).andExpect(status().isAccepted());
	}

	@Test
	public void testRetrieveUserApi() throws Exception {
		mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testUserLogin() throws Exception {
		mockMvc.perform(get("/users/login").queryParam("userName", "Test").queryParam("password", "Test")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
}
