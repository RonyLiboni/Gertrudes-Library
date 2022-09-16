package br.com.gers_library.service.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;

import br.com.gers_library.configurations.ServiceTestTemplate;
import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.exception.IdNotFoundException;
import br.com.gers_library.repositories.employee.EmployeeRepository;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.util.AddressUtil;
import br.com.gers_library.util.EmployeeUtil;
import br.com.gers_library.util.Util;

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
	
	@Test
	void letStringOnlyWithNumbers_ShouldReturnAStringOnlyWithNumbers_WhenThereAreDifferentCharactersInTheString() {	
		assertThat(employeeService.letStringOnlyWithNumbers("@1#2%¨¨3&*()4AS5D'AS/6-+")).isEqualTo("123456");
		assertThat(employeeService.letStringOnlyWithNumbers("1@#%¨2¨'&*3(45)ASDAS/-+6")).isEqualTo("123456");
	}
	
	@Test
	void getAllDto_ShouldReturnPageEntityDto_whenSuccessful() {
		Mockito.when(employeeRepositoryMock.findAll(ArgumentMatchers.any(Util.buildPageable().getClass())))
				.thenReturn(EmployeeUtil.buildPageOfEmployee());

		Page<EmployeeDto> allDto = employeeService.getAllDto(Util.buildPageable());
		
		assertThat(allDto.get().findFirst().get().getFullName()).isEqualTo("Validated employee test");		
	}
	
	@Test
	void getDtoById_ShouldThrowIdNotFoundException_WhenIdDoesntExist() {
		Mockito.when(employeeRepositoryMock.findById(ArgumentMatchers.anyLong()))
				.thenReturn(Optional.empty());
		try {
			employeeService.getDtoById(1L);
			fail();
		} catch (IdNotFoundException e) {
			assertThat(e.getMessage()).isEqualTo("This employee id doesn't exist");
		}
	}
	
	@Test
	void highestIncidenceCep_ShouldReturnAnEmptyList_WhenDataBaseIsEmpty() {
		Mockito.when(employeeRepositoryMock.getOrderedCepCount())
				.thenReturn(new ArrayList<>());
			
		assertThat(employeeService.highestIncidenceCep()).isEmpty();
	}
	
}
