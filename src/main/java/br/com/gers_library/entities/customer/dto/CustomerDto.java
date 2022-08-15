package br.com.gers_library.entities.customer.dto;

import br.com.gers_library.entities.customer.Customer;
import io.swagger.v3.oas.annotations.media.Schema;
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
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Naruto Uzumaki")
	private String fullName;
	
	@Schema(example = "379.365.510-50")
	private String documentCpf;
	
	@Schema(example = "82990-192")
	private String cep;
	
	@Schema(example = "Rua Major Paulo Lessi")
	private String street;
	
	@Schema(example = "1")
	private Integer streetNumber;
	
	@Schema(example = "In front of a convenience store")
	private String complement;
	
	@Schema(example = "Cajuru")
	private String district;
	
	@Schema(example = "Curitiba")
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
		this.id = customer.getId();
	}

}
