package br.com.gers_library.controllers.employee;

import java.util.List;

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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/admin/employee")
@RequiredArgsConstructor
@Tag(name = "Employee Endpoints", description = "Here, you will be able to do all CRUD operations and get the cep with highest incidence from employees.")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping()
	@Operation(summary = "Creates an Employee.")
	@ApiResponse(responseCode= "201", description = "The resource was created with success!")
	public ResponseEntity<EmployeeDto> registerEmployee(@RequestBody @Valid EmployeeFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.registerEmployee(form));
	}
	
	@GetMapping
	@Operation(summary = "Gets all Employees.")
	@ApiResponse(responseCode= "200", description = "The resources was got with success!")
	public ResponseEntity<Page<EmployeeDto>> getAllDto(@PageableDefault() @Parameter(hidden=true) Pageable page){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllDto(page));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Gets an Employees by id.")
	@ApiResponse(responseCode= "200", description = "The resource was got with success!")
	public ResponseEntity<EmployeeDto> getDtoById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getDtoById(id));
	}
	
	@DeleteMapping("/{id}")	
	@Operation(summary = "Deletes an Employees by id.")
	@ApiResponse(responseCode= "204", description = "The resource was deleted with success!")
	public ResponseEntity<?> deleteById(Long id){
		employeeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Updates an Employees by id.")
	@ApiResponse(responseCode= "200", description = "The resource was updated with success!")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeFormDto form) {
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(id, form));
	}
	
	@GetMapping("/highest-incidence-cep")
	@Operation(summary = "Get the cep with highest incidence")
	@ApiResponse(responseCode= "200", description = "The cep with highest incidence was got with success!")
	public ResponseEntity<List<HighestIncidenceCepProjection>> getHighestIncidenceCep(){
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.highestIncidenceCep());
	}
	
	
}
