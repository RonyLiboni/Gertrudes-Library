package br.com.gers_library.service.employee;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.entities.exception.IdNotFoundException;
import br.com.gers_library.repositories.EmployeeRepository;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.service.template.ServiceTemplate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService extends ServiceTemplate{

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
		return employeeRepository.findById(id).orElseThrow(() -> new IdNotFoundException("This employee id doesn't exist"));
	}

	@Transactional
	public void deleteById(Long id) {
		employeeRepository.delete(getById(id));
	}

	public EmployeeDto updateEmployee(Long id, EmployeeFormDto form) {
		return new EmployeeDto(mapAndUpdateAtribbutes(id, form));
	}

	private Employee mapAndUpdateAtribbutes(Long id, EmployeeFormDto form) {
		Employee employeeToBeUpdated = getById(id);
		employeeToBeUpdated.setFullName(form.getFullName());
		employeeToBeUpdated.setDocumentCpf(letStringOnlyWithNumbers(form.getDocumentCpf()));
		employeeToBeUpdated.setJobTitle(form.getJobTitle());
		employeeToBeUpdated.setHireDate(form.getHireDate());
		employeeToBeUpdated.setAddress(addressService.buildAdress(letStringOnlyWithNumbers(form.getCep()),
						form.getStreetNumber(),
						form.getComplement()));
		
		return saveInDataBase(employeeToBeUpdated);
	}

	public HighestIncidenceCepProjection highestIncidenceCep() {
		
		return employeeRepository.getCepWithTheHighestIncidence();
	}
}
