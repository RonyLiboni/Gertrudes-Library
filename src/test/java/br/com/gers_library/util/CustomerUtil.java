package br.com.gers_library.util;

import br.com.gers_library.entities.customer.Customer;
import br.com.gers_library.entities.customer.dto.CustomerDto;
import br.com.gers_library.entities.customer.dto.CustomerFormDto;

public class CustomerUtil {

	public static Customer buildValidatedEntity() {
		return Customer.builder()
				.fullName("Validated Customer test")
				.documentCpf("57494765026")
				.address(AddressUtil.buildValidatedAddress())
				.build();
	}
	
	public static Customer buildNotValidatedEntity() {
		return new Customer();
	}

	public static CustomerFormDto buildValidatedCustomerFormDto() {
		return new CustomerFormDto(buildValidatedEntity());
	}

	public static CustomerDto buildCustomerDto() {
		return new CustomerDto(buildValidatedEntity());
	}

}
