package br.com.gers_library.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;

public class EmployeeUtil {

	public static Employee buildValidatedEntity() {
		return Employee.builder()
				.fullName("Validated employee test")
				.documentCpf("57494765026")
				.hireDate(LocalDate.now())
				.jobTitle("QA Analyst")
				.address(AddressUtil.buildValidatedAddress())
				.build();
	}
	
	public static Employee buildNotValidatedEntity() {
		return new Employee();
	}

	public static EmployeeFormDto buildValidatedEmployeeFormDto() {
		return new EmployeeFormDto(buildValidatedEntity());
	}

	public static EmployeeDto buildEmployeeDto() {
		return new EmployeeDto(buildValidatedEntity());
	}
	
	public static Page<Employee> buildPageOfEmployee() {
		return new PageImpl<>(List.of(buildValidatedEntity()));
	}

}
