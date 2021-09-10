package br.com.itau.password.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.itau.password.PasswordApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = PasswordApplication.class)
@AutoConfigureMockMvc
public class PasswordControllerIntegrationTest {

	@Autowired
    private MockMvc mvc;
	
	@Test
	public void shouldInvalid_whenEmpty() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldInvalid_whenHasLessCharactersThanExpected() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("AbTp9!f")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldInvalid_whenRepeatedCharacter() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("AbTp9!foA")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldInvalid_whenOnlyLowerCase() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("ab")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldInvalid_whenNoDigit() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("AbTp9!foo")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldInvalid_whenHasWhiteSpace() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("AbTp9 fok")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(false)));
	}
	
	@Test
	public void shouldValid_whenOk() throws Exception {
		
		mvc.perform(post("/password/validate")
	    		.content("AbTp9!fok")
	    		.contentType(MediaType.APPLICATION_JSON))
		      	.andExpect(status().isOk())
		      	.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		      	.andExpect(jsonPath("$.isValid", is(true)));
	}
}
