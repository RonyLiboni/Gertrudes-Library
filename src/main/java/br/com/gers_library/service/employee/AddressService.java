package br.com.gers_library.service.employee;

import org.springframework.stereotype.Service;

import br.com.gers_library.entities.library_user.Address;

@Service
public class AddressService {

	public Address buildAdress(String cep, Integer streetNumber, String complement) {
		
		return Address.builder()
				.cep(cep)
				.street("OPEN FEIGN")
				.streetNumber(streetNumber)
				.complement(complement)
				.district("OPEN FEIGN")
				.city("OPEN FEIGN")				
				.build();
	}
	
}
