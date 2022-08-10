package br.com.gers_library.service.employee;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final ModelMapper modelMapper;
	
	public EmployeeDto registerEmployee(EmployeeFormDto form) {
		return new EmployeeDto(saveInDataBase(modelMapper.map(form, Employee.class)));
	}
	
	@Transactional
	public Employee saveInDataBase(Employee employee) {
		return employeeRepository.save(employee);
	}
	
}
