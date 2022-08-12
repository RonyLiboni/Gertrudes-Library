package br.com.gers_library.controllers.exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("testes")
class ExceptionHandlerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	
	private final String employeeUri="/v1/admin/employee";
		
	@Test
	void employeeFormDtoValidation_ShouldReturnBadRequest_WhenFormDtoHasInvalidFields() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders
						.post(employeeUri)
						.content(objectMapper.writeValueAsString(new EmployeeFormDto()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.isBadRequest());
	}

}
