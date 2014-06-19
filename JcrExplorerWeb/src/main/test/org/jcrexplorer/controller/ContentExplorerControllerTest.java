package com.jcrexplorer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


public class ContentExplorerControllerTest extends AbstractControllerTest{

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testRoot() throws Exception{
		 mockMvc.perform(get("/root")
				.accept(MediaType.ALL))
				.andExpect(status().isOk()).andReturn();
				
	}
	
	@Test
	public void testExplore() throws Exception{
		 mockMvc.perform(get("/explore?path=/")
				.accept(MediaType.ALL))
				.andExpect(status().isOk()).andReturn();
	}
	public void testQuery(){
		
	}

	@Configuration
	@EnableWebMvc
	public static class TestConfiguration {
		@Bean
		public ContentExplorerController contentExplorerController() {
			return new ContentExplorerController();
		}
	}
}
