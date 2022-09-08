package br.com.gers_library.controllers.authentication;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.gers_library.configurations.ControllerTestTemplate;
import br.com.gers_library.entities.login.LoginFormDto;

@Profile("Default")
class AuthenticationControllerTest extends ControllerTestTemplate {

	private final String authenticationUri = "/auth";


	@Test
	void authenticateUser_ShouldReturnStatusCodeCreated_WhenUsernameAndPasswordAreCorrect() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post(authenticationUri)
				.content(objectMapper.writeValueAsString(LoginFormDto.builder().username("Rony").password("123456").build()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isCreated());
	}
	
	@Test
	void authenticateUser_ShouldReturnStatusCodeForbidden_WhenUsernameAndPasswordAreNotCorrect() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post(authenticationUri)
				.content(objectMapper.writeValueAsString(LoginFormDto.builder().username("Rony").password("wrongPassword").build()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isForbidden());
	}


}
