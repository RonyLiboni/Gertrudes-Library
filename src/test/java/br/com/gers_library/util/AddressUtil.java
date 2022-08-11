package br.com.gers_library.util;

import br.com.gers_library.entities.library_user.Address;

public class AddressUtil {

	public static Address buildValidatedAddress() {
		return Address.builder()
				.cep("01311-000")
				.city("São Paulo")
				.district("SP")
				.street("Av. Paulista")
				.streetNumber(1)
				.complement("Complemento TESTE")
				.build();
	}
	
}
