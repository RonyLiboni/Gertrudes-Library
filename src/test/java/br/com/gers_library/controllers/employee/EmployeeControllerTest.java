package br.com.gers_library.controllers.employee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.service.employee.EmployeeService;
import br.com.gers_library.service.employee.ServiceTestTemplate;
import br.com.gers_library.util.EmployeeUtil;

class EmployeeControllerTest extends ServiceTestTemplate {
	
	@InjectMocks
	private EmployeeController employeeController;
	@Mock
	private EmployeeService employeeServiceMock;
	
	@Test
	void registerEmployee_ShouldReturnStatusCodeCreated_WhenEntityHasAllFieldsValidated() {
		Mockito.when(employeeServiceMock.registerEmployee(ArgumentMatchers.any(EmployeeFormDto.class)))
				.thenReturn(EmployeeUtil.buildEmployeeDto());
		ResponseEntity<EmployeeDto> responseEntity = employeeController.registerEmployee(EmployeeUtil.buildValidatedEmployeeFormDto());
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}

}
