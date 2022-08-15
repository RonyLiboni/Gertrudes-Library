package br.com.gers_library.controllers.customer;

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

import br.com.gers_library.entities.customer.dto.CustomerDto;
import br.com.gers_library.entities.customer.dto.CustomerFormDto;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/admin/customer")
@RequiredArgsConstructor
@Tag(name = "Customer Endpoints", description = "Here, you will be able to do all CRUD operations and get the cep with highest incidence from customers.")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@PostMapping
	@Operation(summary = "Creates an Customer.")
	@ApiResponse(responseCode= "201", description = "The resource was created with success!")
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody @Valid CustomerFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(form));
	}
	
	@GetMapping
	@Operation(summary = "Gets all Customers.")
	@ApiResponse(responseCode= "200", description = "The resources was got with success!")
	public ResponseEntity<Page<CustomerDto>> getAllDto(@PageableDefault()@Parameter(hidden=true) Pageable page){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllDto(page));
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Gets an Customers by id.")
	@ApiResponse(responseCode= "200", description = "The resource was got with success!")
	public ResponseEntity<CustomerDto> getDtoById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getDtoById(id));
	}
	
	@DeleteMapping("/{id}")	
	@Operation(summary = "Deletes an Customers by id.")
	@ApiResponse(responseCode= "204", description = "The resource was deleted with success!")
	public ResponseEntity<?> deleteById(Long id){
		customerService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Updates an Customers by id.")
	@ApiResponse(responseCode= "200", description = "The resource was updated with success!")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerFormDto form) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, form));
	}
	
	@GetMapping("/highest-incidence-cep")
	@Operation(summary = "Get the cep with highest incidence")
	@ApiResponse(responseCode= "200", description = "The cep with highest incidence was got with success!")
	public ResponseEntity<List<HighestIncidenceCepProjection>> getHighestIncidenceCep(){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.highestIncidenceCep());
	}
	
}
