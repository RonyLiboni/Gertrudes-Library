package br.com.gers_library.controllers.employee;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.gers_library.configurations.ControllerTestTemplate;
import br.com.gers_library.util.EmployeeUtil;

class EmployeeControllerTest extends ControllerTestTemplate {

	private final String employeeUri = "/v1/admin/employee";
	private final String id = "/{id}";

	@Test
	void registerEmployee_ShouldReturnStatusCodeCreated_WhenEntityHasAllFieldsValidated() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post(employeeUri)
				.content(objectMapper.writeValueAsString(EmployeeUtil.buildValidatedEmployeeFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isCreated());
	}

	@Test
	void updateEmployee_ShouldReturnStatusCodeOk_WhenEntityHasAllFieldsValidated() throws Exception {
		employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.put(employeeUri+id, employeeRepository.findAll().get(0).getId())
				.content(objectMapper.writeValueAsString(EmployeeUtil.buildValidatedEmployeeFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void getAllDto_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(employeeUri))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void getDtoById_ShouldReturnStatusCodeOk_WhenIdExists() throws Exception {
		employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.get(employeeUri+id,employeeRepository.findAll().get(0).getId()))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void deleteById_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.delete(employeeUri+id, employeeRepository.findAll().get(0).getId()))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNoContent());
	}

	@Test
	void getHighestIncidenceCep_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(employeeUri+"/highest-incidence-cep"))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

}
