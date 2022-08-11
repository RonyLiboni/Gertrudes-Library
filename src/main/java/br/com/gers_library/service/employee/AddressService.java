package br.com.gers_library.service.employee;

import org.springframework.stereotype.Service;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.http.CepConsumerFeign;
import br.com.gers_library.http.ViaCepAddress;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
	
	private final CepConsumerFeign cepConsumer;
	
	public Address buildAdress(String cep, Integer streetNumber, String complement) {
		ViaCepAddress viaCepAddress = cepConsumer.getFullAddres(cep);
		return Address.builder()
				.cep(cep)
				.street(viaCepAddress.getLogradouro())
				.streetNumber(streetNumber)
				.complement(complement)
				.district(viaCepAddress.getBairro())
				.city(viaCepAddress.getLocalidade())				
				.build();
	}
	
}
