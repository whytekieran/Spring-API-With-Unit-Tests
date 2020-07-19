package com.whyte.accela;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.whyte.accela.person.PersonController;

//Do not start the server, spring will handle the request and hand it off to my controller.
@SpringBootTest
@AutoConfigureMockMvc
class PersonApiDataApplicationTest {

	@Autowired
	private PersonController personController;
	
	@Autowired
	private MockMvc mockMvc;
	
	//Check application context and the person controller have loaded successfully
	@Test
	@Order(1)
	public void contextLoads() throws Exception {
		assertThat(personController).isNotNull();
	}

	@Test
	@Order(2)
	public void addPerson() throws Exception {
		this.mockMvc.perform(post("/people")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content("{\"id\":2,\"firstName\":\"btnfdsfvdshj\",\"lastName\":\"fvvvvvvffe\"}"))
	            .andDo(print())
	            .andExpect(status().isOk());
	}
	
	@Test
	@Order(3)
	public void checkPersonTotalAfter() throws Exception {
		this.mockMvc.perform(get("/people/amount")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("1")));
	}
}
