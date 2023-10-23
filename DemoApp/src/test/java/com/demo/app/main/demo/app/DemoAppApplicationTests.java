package com.demo.app.main.demo.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class DemoAppApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestRestTemplate template;
	
	private final String INDEX_PAGE_TEXT = "IndexPage";
	
	// Mocking the HTTP request cycle
	@Test
	public void contextLoads() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string(equalTo(INDEX_PAGE_TEXT)));
	}
	
	// Full-stack integration test
	@Test
	public void getHello() throws Exception {
		ResponseEntity<String> response = template.getForEntity("/", String.class);
		
		assertThat(response.getBody()).isEqualTo(INDEX_PAGE_TEXT);
	}

}
