package br.com.gers_library.service.employee;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
				.documentCpf(letStringOnlyWithNumbers(form.getDocumentCpf()))
				.jobTitle(form.getJobTitle())
				.hireDate(form.getHireDate())
				.address(addressService.buildAdress(letStringOnlyWithNumbers(form.getCep()),
						form.getStreetNumber(),
						form.getComplement()))
				.build()));
	}

	private String letStringOnlyWithNumbers(String string) {
		return string.replaceAll("[^0-9]", "");
	}

	@Transactional
	public Employee saveInDataBase(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Page<Employee> getAll(Pageable page){
		return employeeRepository.findAll(page);
	}
	
	public Page<EmployeeDto> getAllDto(Pageable page){
		return getAll(page).map(EmployeeDto::new);
	}

	public EmployeeDto getDtoById(Long id) {
		return new EmployeeDto(getById(id));
	}

	private Employee getById(Long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("This employee id doesn't exist"));
	}
}
