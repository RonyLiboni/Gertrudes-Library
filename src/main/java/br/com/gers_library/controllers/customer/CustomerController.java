package br.com.gers_library.controllers.customer;

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
import br.com.gers_library.service.employee.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/admin/customer")
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<CustomerDto> registerCustomer(@RequestBody @Valid CustomerFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.registerCustomer(form));
	}
	
	@GetMapping
	public ResponseEntity<Page<CustomerDto>> getAllDto(@PageableDefault() Pageable page){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllDto(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> getDtoById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(customerService.getDtoById(id));
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<?> deleteById(Long id){
		customerService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerFormDto form) {
		return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(id, form));
	}
	
}
