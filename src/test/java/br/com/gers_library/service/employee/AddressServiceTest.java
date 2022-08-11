package br.com.gers_library.service.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.http.CepConsumerFeign;
import br.com.gers_library.util.AddressUtil;

class AddressServiceTest extends ServiceTestTemplate{
	
	@InjectMocks
	private AddressService addressService;
	@Mock
	private CepConsumerFeign cepConsumerMock;
	
	@Test
	void buildAddress_ShouldReturnAnAddress_WhenCepExists() {
		Mockito.when(cepConsumerMock.getFullAddres(ArgumentMatchers.anyString()))
				.thenReturn(AddressUtil.buildViaCepAddress());
		
		assertThat(addressService.buildAdress("01001-000", 1, "lado ímpar"))
			.isExactlyInstanceOf(Address.class)
			.isNotNull();	
	}
	
	
}
