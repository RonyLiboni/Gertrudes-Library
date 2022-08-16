package br.com.gers_library.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gers_library.configurations.RepositoryTestTemplate;
import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.repositories.employee.EmployeeRepository;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.util.EmployeeUtil;

class EmployeeRepositoryTest extends RepositoryTestTemplate  {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void getOrderedCepCount_ShouldReturnAListWithTheHighestIncidenceCepInTheIndex0_WhenSuccessful() {	
		employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		employeeRepository.save(Employee.builder()
				.fullName("XXXX test 2")
				.documentCpf("XXXX")
				.hireDate(LocalDate.now())
				.jobTitle("XXXX")
				.address(Address.builder()
							.cep("XXXX")
							.city("São Paulo")
							.district("XX")
							.street("Praça da Sé")
							.streetNumber(1)
							.complement("lado ímpar")
							.build())
				.build());
		List<HighestIncidenceCepProjection> orderedCepCount = employeeRepository.getOrderedCepCount();
		assertThat(orderedCepCount.get(0).getCepCount()).isEqualTo(2);
		assertThat(orderedCepCount.get(1).getCepCount()).isEqualTo(1);
		assertThat(orderedCepCount.size()).isEqualTo(2);
	}

}
