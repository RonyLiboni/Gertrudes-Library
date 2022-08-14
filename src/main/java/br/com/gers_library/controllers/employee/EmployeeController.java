package br.com.gers_library.controllers.employee;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/admin/employee")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody @Valid EmployeeFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.registerEmployee(form));
	}
	
	@GetMapping
	public ResponseEntity<Page<EmployeeDto>> getAllDto(@PageableDefault() Pageable page){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllDto(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getDtoById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getDtoById(id));
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> deleteById(Long id){
		employeeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeFormDto form) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, form));
	}
	
	@GetMapping("/highest-incidence-cep")
	public ResponseEntity<HighestIncidenceCepProjection> getHighestIncidenceCep(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.highestIncidenceCep());
	}
	
	
}
