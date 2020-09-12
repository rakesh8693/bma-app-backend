package com.company.bma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Ignore;
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

import com.company.bma.controller.Impl.ShortUrlController;
import com.company.bma.model.ShortUrlRequest;
import com.company.bma.service.ShortUrlService;
import com.company.bma.utils.JsonUtils;

@RunWith(SpringRunner.class)
@WebMvcTest(ShortUrlController.class)
@AutoConfigureMockMvc(addFilters = false)
@TestPropertySource("classpath:application.properties")
public class ShortUrlControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ShortUrlService shortUrlService;

	@Test
	public void testCreateShortUrlApi() throws Exception {
		mockMvc.perform(post("/shortUrl")
				.content(JsonUtils.asJsonString(new ShortUrlRequest("longUrl",new Date(),1)))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

	@Test
	public void testRetrieveShortUrlApi() throws Exception {
		mockMvc.perform(get("/shortUrl/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	@Ignore
	public void testShareShortUrlApi() throws Exception {
		mockMvc.perform(get("/shareShortUrl/{id}", 1).accept(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk());
	}
}
