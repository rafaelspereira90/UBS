package br.com.rafael.ubs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	public WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void CreatUserTest() throws Exception {
		
		String json = "{\"name\": \"Rafael\", \"email\": \"rafaelspereira90@gmail.com\", \"password\": \"999999\" }";
		
		this.mvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	public void CreatUserFailureTest() throws Exception {
		
		String json = "{\"name\": \"Rafael\", \"email\": \"a.com\", \"password\": \"11\" }";
		
		this.mvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
}
