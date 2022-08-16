package br.com.gers_library.controllers.customer;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.gers_library.configurations.ControllerTemplateTestConfig;
import br.com.gers_library.util.CustomerUtil;

class CustomerControllerTest extends ControllerTemplateTestConfig {

	private final String customerUri = "/v1/admin/customer";
	private final String id = "/{id}";

	@Test
	void registerEmployee_ShouldReturnStatusCodeCreated_WhenEntityHasAllFieldsValidated() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.post(customerUri)
				.content(objectMapper.writeValueAsString(CustomerUtil.buildValidatedCustomerFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isCreated());
	}

	@Test
	void updateEmployee_ShouldReturnStatusCodeOk_WhenEntityHasAllFieldsValidated() throws Exception {
		customerRepository.save(CustomerUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.put(customerUri+id, customerRepository.findAll().get(0).getId())
				.content(objectMapper.writeValueAsString(CustomerUtil.buildValidatedCustomerFormDto()))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void getAllDto_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(customerUri))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void getDtoById_ShouldReturnStatusCodeOk_WhenIdExists() throws Exception {
		customerRepository.save(CustomerUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.get(customerUri+id,customerRepository.findAll().get(0).getId()))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

	@Test
	void deleteById_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		customerRepository.save(CustomerUtil.buildValidatedEntity());
		mockMvc.perform(MockMvcRequestBuilders
				.delete(customerUri+id, customerRepository.findAll().get(0).getId()))
		.andExpect(MockMvcResultMatchers
				.status()
				.isNoContent());
	}

	@Test
	void getHighestIncidenceCep_ShouldReturnStatusCodeOk_WhenSuccessful() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
				.get(customerUri+"/highest-incidence-cep"))
		.andExpect(MockMvcResultMatchers
				.status()
				.isOk());
	}

}
