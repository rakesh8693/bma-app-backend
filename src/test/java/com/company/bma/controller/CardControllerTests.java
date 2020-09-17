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

import com.company.bma.controller.Impl.CardController;
import com.company.bma.model.CardRequest;
import com.company.bma.security.CustomAuthenticationProvider;
import com.company.bma.service.CardService;
import com.company.bma.utils.JsonUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource("classpath:application.properties")
public class CardControllerTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CardService CardService;
	
	@MockBean
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Test
	public void testCreateCardApi() throws Exception {
		mockMvc.perform(post("/card/{id}", 1)
				.content(JsonUtils.asJsonString(new CardRequest(1, "cardTitle", "cardDescription", "cardIconLocation")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	
	@Test
	public void testRetrieveCardApi() throws Exception {
		mockMvc.perform(get("/card/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateCardApi() throws Exception {
		mockMvc.perform(put("/card/{id}", 1)
				.content(JsonUtils
						.asJsonString(new CardRequest(1, "cardTitle", "cardDescription", "DefaultIconLocation")))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}

	@Test
	public void testDeleteCardApi() throws Exception {
		mockMvc.perform(delete("/card/{id}", 1)).andExpect(status().isAccepted());
	}
	
	
	@Test
	public void testChangesToValidateApi() throws Exception{
		mockMvc.perform(get("/validateCard/{id}", 1).queryParam("groupCategory","TRIBE").queryParam("groupName","Test").accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk());
	}

}
