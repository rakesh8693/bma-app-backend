package com.company.bma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.company.bma.controller.Impl.GroupController;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.GroupRequest;
import com.company.bma.security.CustomAuthenticationProvider;
import com.company.bma.service.GroupService;
import com.company.bma.utils.JsonUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource("classpath:application.properties")
public class GroupControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GroupService groupService;
	
	@MockBean
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Test
	public void testCreateGroupApi() throws Exception {
		mockMvc.perform(
				post("/group").content(JsonUtils.asJsonString(new GroupRequest(GroupCategory.TRIBE, "GroupName", 1)))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void testRetrieveCardByGroupApi() throws Exception {
		mockMvc.perform(get("/group/{groupCategory}/export/{groupName}/card", "TRIBE", "GroupName")
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void testRetrieveGroupNameApi() throws Exception {
		mockMvc.perform(get("/groupNames/{groupCategory}", "TRIBE").accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testAddCardToGroupApi() throws Exception {
		mockMvc.perform(
				post("/group/{id}",1).content(JsonUtils.asJsonString(new GroupRequest(GroupCategory.TRIBE, "GroupName", 1)))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

}
