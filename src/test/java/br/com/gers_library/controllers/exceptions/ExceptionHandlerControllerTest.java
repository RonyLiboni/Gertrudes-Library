package br.com.gers_library.controllers.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.gers_library.configurations.ControllerTemplateTestConfig;
import br.com.gers_library.entities.customer.dto.CustomerFormDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.util.CustomerUtil;
import br.com.gers_library.util.EmployeeUtil;

class ExceptionHandlerControllerTest extends ControllerTemplateTestConfig{
		
	private final String employeeUri="/v1/admin/employee";
	private final String customerUri="/v1/admin/customer";
	private final String id="/{id}";
		
	@Test
	void employeeFormDtoValidation_PostMapping_ShouldReturnBadRequestAndValidationErrors_WhenFormDtoHasInvalidFields() throws Exception{
		ResultActions postResult = mockMvc.perform(MockMvcRequestBuilders
						.post(employeeUri)
						.content(objectMapper.writeValueAsString(new EmployeeFormDto()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers
						.status()
						.isBadRequest());
		
		String postErrors = postResult.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertThat(postErrors).contains("fullName");
		assertThat(postErrors).contains("documentCpf");
		assertThat(postErrors).contains("jobTitle");
		assertThat(postErrors).contains("hireDate");
		assertThat(postErrors).contains("cep");
		assertThat(postErrors).contains("streetNumber");
	}
	
	@Test
	void employeeFormDtoValidation_PutMapping_ShouldReturnBadRequestAndValidationErrors_WhenFormDtoHasInvalidFields() throws Exception{
		ResultActions putResult = mockMvc.perform(MockMvcRequestBuilders
				.put(employeeUri+id, -1L)
				.content(objectMapper.writeValueAsString(new EmployeeFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isBadRequest());
		
		String putErrors = putResult.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
		
		assertThat(putErrors).contains("fullName");
		assertThat(putErrors).contains("documentCpf");
		assertThat(putErrors).contains("jobTitle");
		assertThat(putErrors).contains("hireDate");
		assertThat(putErrors).contains("cep");
		assertThat(putErrors).contains("streetNumber");
	}
	
	@Test
	void customerFormDtoValidation_PostMapping_ShouldReturnBadRequestAndValidationErrors_WhenFormDtoHasInvalidFields() throws Exception{
		ResultActions postResult = mockMvc.perform(MockMvcRequestBuilders
				.post(customerUri)
				.content(objectMapper.writeValueAsString(new CustomerFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isBadRequest());

		String postErrors = postResult.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

		assertThat(postErrors).contains("fullName");
		assertThat(postErrors).contains("documentCpf");
		assertThat(postErrors).contains("cep");
		assertThat(postErrors).contains("streetNumber");
	}
	
	@Test
	void customerFormDtoValidation_PutMapping_ShouldReturnBadRequestAndValidationErrors_WhenFormDtoHasInvalidFields() throws Exception{		
		ResultActions putResult = mockMvc.perform(MockMvcRequestBuilders
				.put(customerUri+id, -1L)
				.content(objectMapper.writeValueAsString(new CustomerFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isBadRequest());
		
		String putErrors = putResult.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
	
		assertThat(putErrors).contains("fullName");
		assertThat(putErrors).contains("documentCpf");
		assertThat(putErrors).contains("cep");
		assertThat(putErrors).contains("streetNumber");
	}
	
	@Test
	public void employeeController_getDtoById_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(employeeUri+id,-1L))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}
	
	@Test
	public void employeeController_deleteById_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.delete(employeeUri+id, -1L))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}
	
	@Test
	public void employeeController_UpdateEmployee_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.put(employeeUri+id, -1L)
				.content(objectMapper.writeValueAsString(EmployeeUtil.buildValidatedEmployeeFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}
	
	@Test
	public void customerController_getDtoById_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {		
		mockMvc.perform(MockMvcRequestBuilders
				.get(customerUri+id,1L))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}
	
	@Test
	public void customerController_deleteById_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {		
		mockMvc.perform(MockMvcRequestBuilders
				.delete(customerUri+id, -1L))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}
	
	@Test
	public void customerController_getDtoById_deleteById_UpdateCustomer_ShouldReturnNotFound_WhenIdDoesntExist() throws Exception {		
		mockMvc.perform(MockMvcRequestBuilders
				.put(customerUri+id, -1L)
				.content(objectMapper.writeValueAsString(CustomerUtil.buildValidatedCustomerFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNotFound());
	}

}
