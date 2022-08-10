package br.com.gers_library;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gers_library.entities.employee.dto.EmployeeDto;
import br.com.gers_library.entities.employee.dto.EmployeeFormDto;
import br.com.gers_library.service.employee.EmployeeService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/admin/employee")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody @Valid EmployeeFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.registerEmployee(form));
	}
	
}
