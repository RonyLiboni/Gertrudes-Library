package br.com.gers_library.util;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.http.ViaCepAddress;

public class AddressUtil {

	public static Address buildValidatedAddress() {
		return Address.builder()
				.cep("01001000")
				.city("São Paulo")
				.district("SP")
				.street("Praça da Sé")
				.streetNumber(1)
				.complement("lado ímpar")
				.build();
	}

	public static ViaCepAddress buildViaCepAddress() {
		return ViaCepAddress.builder()
				.cep("01001000")
				.bairro("Sé")
				.complemento("lado ímpar")
				.ddd("11")
				.gia("1004")
				.ibge("3550308")
				.localidade("São Paulo")
				.logradouro("Praça da Sé")
				.uf("SP")
				.siafi("7107")
				.build();
	}
	
}
