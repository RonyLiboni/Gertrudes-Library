package br.com.gers_library.service.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.http.CepConsumerFeign;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.util.AddressUtil;

class AddressServiceTest extends ServiceTestTemplate{
	
	@InjectMocks
	private AddressService addressService;
	@Mock
	private CepConsumerFeign cepConsumerMock;
	
	@Test
	void buildAddress_ShouldReturnAnAddress_WhenCepExists() {
		Mockito.when(cepConsumerMock.getFullAddres(ArgumentMatchers.anyString()))
				.thenReturn(ResponseEntity.ok(AddressUtil.buildViaCepAddress()));
		
		Address fullAddress = addressService.buildAdress("01001-000", 1, "lado ímpar");
		
		assertThat(fullAddress)
			.isExactlyInstanceOf(Address.class)
			.isNotNull();
		
		assertThat(fullAddress.getCity()).isNotNull();
		assertThat(fullAddress.getDistrict()).isNotNull();
		assertThat(fullAddress.getStreet()).isNotNull();
		assertThat(fullAddress.getCity()).isNotNull();
	}
	
	
}
