package br.com.gers_library.service.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

import br.com.gers_library.configurations.ServiceTestTemplate;
import br.com.gers_library.entities.customer.Customer;
import br.com.gers_library.entities.customer.dto.CustomerDto;
import br.com.gers_library.entities.exception.IdNotFoundException;
import br.com.gers_library.repositories.customer.CustomerRepository;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.util.AddressUtil;
import br.com.gers_library.util.CustomerUtil;
import br.com.gers_library.util.HighestIncidenceCepProjectionTestUtil;
import br.com.gers_library.util.Util;

class CustomerServiceTest extends ServiceTestTemplate {

	@InjectMocks
	private CustomerService customerService;
	@Mock
	private CustomerRepository customerRepositoryMock;
	@Mock
	private AddressService addressServiceMock;

	@Test
	void registerCustomer_ShouldReturnEntityDto_WhenEntityFormDtoHasAllFieldsValidated() {
		Mockito.when(customerRepositoryMock.save(ArgumentMatchers.any(Customer.class)))
				.thenReturn(CustomerUtil.buildValidatedEntity());

		Mockito.when(addressServiceMock.buildAdress(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), 
				ArgumentMatchers.anyString()))
				.thenReturn(AddressUtil.buildValidatedAddress());
			
		assertThat(customerService.registerCustomer(CustomerUtil.buildValidatedCustomerFormDto()))
			.isNotNull()
			.isExactlyInstanceOf(CustomerDto.class);
	}
	
	@Test
	void letStringOnlyWithNumbers_ShouldReturnAStringOnlyWithNumbers_WhenThereAreDifferentCharactersInTheString() {	
		assertThat(customerService.letStringOnlyWithNumbers("@1#2%¨¨3&*()4AS5D'AS/6-+")).isEqualTo("123456");
		assertThat(customerService.letStringOnlyWithNumbers("1@#%¨2¨'&*3(45)ASDAS/-+6")).isEqualTo("123456");
	}
	
	@Test
	void getAllDto_ShouldReturnPageEntityDto_whenSuccessful() {
		Mockito.when(customerRepositoryMock.findAll(ArgumentMatchers.any(Util.buildPageable().getClass())))
				.thenReturn(CustomerUtil.buildPageOfCustomer());

		Page<CustomerDto> allDto = customerService.getAllDto(Util.buildPageable());
		
		assertThat(allDto.get().findFirst().get().getFullName()).isEqualTo("Validated Customer test");		
	}
	
	@Test
	void getDtoById_ShouldThrowIdNotFoundException_WhenIdDoesntExist() {
		Mockito.when(customerRepositoryMock.findById(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.empty());
		try {
			customerService.getDtoById(1L);
			fail();
		} catch (IdNotFoundException e) {
			assertThat(e.getMessage()).isEqualTo("This customer id doesn't exist");
		}
	}
	
	@Test
	void highestIncidenceCep_ShouldReturnAnEmptyList_WhenDataBaseIsEmpty() {
		Mockito.when(customerRepositoryMock.getOrderedCepCount())
				.thenReturn(new ArrayList<>());
			
		assertThat(customerService.highestIncidenceCep()).isEmpty();
	}
	
	@Test
	void highestIncidenceCep_ShouldReturnAListWithOneEntity_WhenThereIsOnlyOneHighestIncidenceCep() {
		Mockito.when(customerRepositoryMock.getOrderedCepCount())
				.thenReturn(HighestIncidenceCepProjectionTestUtil.buildListWithOneCepCountAsTheHighest());
		
		List<HighestIncidenceCepProjection> highestIncidenceCep = customerService.highestIncidenceCep();
		
		assertThat(HighestIncidenceCepProjectionTestUtil.buildListWithOneCepCountAsTheHighest().size()).isEqualTo(3);//The mock returns a list with 3 entities
		assertThat(highestIncidenceCep.size()).isEqualTo(1); // Only one entity is left after the method 
	}
	
	@Test
	void highestIncidenceCep_ShouldReturnAListWithTwoEntities_WhenThereAreTwoOrMoreHighestIncidenceCep() {
		Mockito.when(customerRepositoryMock.getOrderedCepCount())
				.thenReturn(HighestIncidenceCepProjectionTestUtil.buildListWithTwoCepCountAsTheHighest());
		
		List<HighestIncidenceCepProjection> highestIncidenceCep = customerService.highestIncidenceCep();
		
		assertThat(HighestIncidenceCepProjectionTestUtil.buildListWithTwoCepCountAsTheHighest().size()).isEqualTo(3);//The mock returns a list with 3 entities
		assertThat(highestIncidenceCep.size()).isEqualTo(2); // Only two entities are left after the method because their cepCount are the highest and are equal 
	}
}
