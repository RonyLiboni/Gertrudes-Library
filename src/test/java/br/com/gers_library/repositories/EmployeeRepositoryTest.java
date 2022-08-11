package br.com.gers_library.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.gers_library.configurations.RepositoryTestTemplate;
import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.util.EmployeeUtil;

class EmployeeRepositoryTest extends RepositoryTestTemplate  {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	void save_ShouldSaveEntityInTheDataBase_WhenItReceivesAnEntityWithAllFieldsValidated() {	
		Employee savedEmployee = employeeRepository.save(EmployeeUtil.buildValidatedEntity());
		assertThat(savedEmployee.getId()).isNotNull();
	}

}
