package br.com.gers_library.entities.customer.dto;

import java.time.LocalDate;

import br.com.gers_library.entities.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
	
	private String fullName;
	private String documentCpf;
	private String cep;
	private String street;
	private Integer streetNumber;
	private String complement;
	private String district;
	private String city;
	
	public CustomerDto(Customer customer) {
		this.fullName = customer.getFullName();
		this.documentCpf = customer.getDocumentCpf();
		this.cep = customer.getAddress().getCep();
		this.street = customer.getAddress().getStreet();
		this.streetNumber = customer.getAddress().getStreetNumber();
		this.complement = customer.getAddress().getComplement();
		this.district = customer.getAddress().getDistrict();
		this.city = customer.getAddress().getCity();
	}

}
