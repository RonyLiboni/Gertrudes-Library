package br.com.gers_library.service.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.repositories.EmployeeRepository;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.util.AddressUtil;
import br.com.gers_library.util.EmployeeUtil;

class EmployeeServiceTest extends ServiceTestTemplate {

	@InjectMocks
	private EmployeeService employeeService;
	@Mock
	private EmployeeRepository employeeRepositoryMock;
	@Mock
	private AddressService addressServiceMock;

	@Test
	void registerEmployee_ShouldReturnEntityDto_WhenEntityFormDtoHasAllFieldsValidated() {
		Mockito.when(employeeRepositoryMock.save(ArgumentMatchers.any(Employee.class)))
				.thenReturn(EmployeeUtil.buildValidatedEntity());

		Mockito.when(addressServiceMock.buildAdress(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), 
				ArgumentMatchers.anyString()))
				.thenReturn(AddressUtil.buildValidatedAddress());
			
		assertThat(employeeService.registerEmployee(EmployeeUtil.buildValidatedEmployeeFormDto()))
		.isNotNull()
		.isExactlyInstanceOf(EmployeeDto.class);
		
	}

}
