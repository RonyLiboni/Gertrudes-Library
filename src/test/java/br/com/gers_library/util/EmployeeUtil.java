package br.com.gers_library.util;

import java.time.LocalDate;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;

public class EmployeeUtil {

	public static EmployeeFormDto buildValidatedEmployeeFormDto;

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
		return Employee.builder().build();
	}

	public static EmployeeFormDto buildValidatedEmployeeFormDto() {
		return new EmployeeFormDto(buildValidatedEntity());
	}

}
