package br.com.gers_library.service.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gers_library.entities.customer.Customer;
import br.com.gers_library.entities.customer.dto.CustomerDto;
import br.com.gers_library.entities.customer.dto.CustomerFormDto;
import br.com.gers_library.entities.exception.IdNotFoundException;
import br.com.gers_library.repositories.customer.CustomerRepository;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;
import br.com.gers_library.service.address.AddressService;
import br.com.gers_library.service.template.ServiceTemplate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService extends ServiceTemplate{

	private final CustomerRepository customerRepository;
	private final AddressService addressService;

	public CustomerDto registerCustomer(CustomerFormDto form) {
		return new CustomerDto(saveInDataBase(
				Customer.builder()
				.fullName(form.getFullName())
				.documentCpf(letStringOnlyWithNumbers(form.getDocumentCpf()))
				.address(addressService.buildAdress(letStringOnlyWithNumbers(form.getCep()),
						form.getStreetNumber(),
						form.getComplement()))
				.build()));
	}

	@Transactional
	public Customer saveInDataBase(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Page<Customer> getAll(Pageable page){
		return customerRepository.findAll(page);
	}
	
	public Page<CustomerDto> getAllDto(Pageable page){
		return getAll(page).map(CustomerDto::new);
	}

	public CustomerDto getDtoById(Long id) {
		return new CustomerDto(getById(id));
	}

	private Customer getById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new IdNotFoundException("This customer id doesn't exist"));
	}

	@Transactional
	public void deleteById(Long id) {
		customerRepository.delete(getById(id));
	}

	public CustomerDto updateCustomer(Long id, CustomerFormDto form) {
		return new CustomerDto(mapAndUpdateAtribbutes(id, form));
	}

	private Customer mapAndUpdateAtribbutes(Long id, CustomerFormDto form) {
		Customer customerToBeUpdated = getById(id);
		customerToBeUpdated.setFullName(form.getFullName());
		customerToBeUpdated.setDocumentCpf(letStringOnlyWithNumbers(form.getDocumentCpf()));
		customerToBeUpdated.setAddress(addressService.buildAdress(letStringOnlyWithNumbers(form.getCep()),
						form.getStreetNumber(),
						form.getComplement()));
		
		return saveInDataBase(customerToBeUpdated);
	}
	
	public List<HighestIncidenceCepProjection> highestIncidenceCep() {
		return customerRepository.getOrderedCepCount();
	}
}
