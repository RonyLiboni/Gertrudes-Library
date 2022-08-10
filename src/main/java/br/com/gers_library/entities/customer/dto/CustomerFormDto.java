package br.com.gers_library.entities.customer.dto;

import javax.validation.constraints.NotBlank;

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
public class CustomerFormDto {
	@NotBlank
	private String fullName;
	@NotBlank
	private String documentCpf;
	@NotBlank 
	private String cep;
	@NotBlank
	private Integer streetNumber;
	private String complement;
	
	public CustomerFormDto(Customer customer) {
		this.fullName = customer.getFullName();
		this.documentCpf = customer.getDocumentCpf();
		this.cep = customer.getAddress().getCep();
		this.streetNumber = customer.getAddress().getStreetNumber();
		this.complement = customer.getAddress().getComplement();
	}
}
