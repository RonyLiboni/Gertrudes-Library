package br.com.gers_library.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gers_library.configurations.RepositoryTestTemplate;
import br.com.gers_library.entities.customer.Customer;
import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.repositories.customer.CustomerRepository;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.util.CustomerUtil;

class EmployeeRepositoryTest extends RepositoryTestTemplate  {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void getOrderedCepCount_ShouldReturnAListWithTheHighestIncidenceCepInTheIndex0_WhenSuccessful() {	
		customerRepository.save(CustomerUtil.buildValidatedEntity());
		customerRepository.save(CustomerUtil.buildValidatedEntity());
		customerRepository.save(Customer.builder()
				.fullName("XXXX test 2")
				.documentCpf("XXXX")
				.address(Address.builder()
							.cep("XXXX")
							.city("São Paulo")
							.district("XX")
							.street("Praça da Sé")
							.streetNumber(1)
							.complement("lado ímpar")
							.build())
				.build());
		
		List<HighestIncidenceCepProjection> orderedCepCount = customerRepository.getOrderedCepCount();
		assertThat(orderedCepCount.get(0).getCepCount()).isEqualTo(2);
		assertThat(orderedCepCount.get(1).getCepCount()).isEqualTo(1);
		assertThat(orderedCepCount.size()).isEqualTo(2);
	}

}
