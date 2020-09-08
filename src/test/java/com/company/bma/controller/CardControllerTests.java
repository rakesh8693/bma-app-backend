package com.company.bma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.company.bma.controller.Impl.CardController;
import com.company.bma.model.Card;




@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
@AutoConfigureMockMvc(addFilters = false)
public class CardControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
    @Test
	public void testCreateCardApi() throws Exception{
    	
	}
    @Test
	public void testRetrieveCard() throws Exception {
		mockMvc.perform(get("/card").queryParam("id","1").queryParam("groupBy", "1001").queryParam("groupName", "test")).andExpect(status().isOk());
	}

	ResponseEntity<Void> updateCard(Card card) {
		return null;
	}

	ResponseEntity<Void> deleteCard(Integer id) {
		return null;
	}

}
