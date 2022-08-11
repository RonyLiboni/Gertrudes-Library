package br.com.gers_library.service.employee;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final AddressService addressService;
	
	public EmployeeDto registerEmployee(EmployeeFormDto form) {
		return new EmployeeDto(saveInDataBase(Employee.builder()
				.fullName(form.getFullName())
				.documentCpf(form.getDocumentCpf())
				.jobTitle(form.getJobTitle())
				.hireDate(form.getHireDate())
				.address(addressService.buildAdress(form.getCep(),form.getStreetNumber(), form.getComplement()))
				.build()));
	}
	
	@Transactional
	public Employee saveInDataBase(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
