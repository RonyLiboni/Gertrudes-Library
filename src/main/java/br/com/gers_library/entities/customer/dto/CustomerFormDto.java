package br.com.gers_library.entities.customer.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.gers_library.entities.customer.Customer;
import br.com.gers_library.validation.cep.CepExists;
import br.com.gers_library.validation.document_cpf.DocumentCpfIsValid;
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
public class CustomerFormDto {
	
	@NotBlank
	@Schema(example = "Naruto Uzumaki")
	private String fullName;
	
	@DocumentCpfIsValid
	@Schema(example = "379.365.510-50")
	private String documentCpf;
	
	@CepExists
	@Schema(example = "82990-192")
	private String cep;
	
	@NotNull
	@Schema(example = "1")
	private Integer streetNumber;
	
	@Schema(example = "In front of a convenience store")
	private String complement;
	
	public CustomerFormDto(Customer customer) {
		this.fullName = customer.getFullName();
		this.documentCpf = customer.getDocumentCpf();
		this.cep = customer.getAddress().getCep();
		this.streetNumber = customer.getAddress().getStreetNumber();
		this.complement = customer.getAddress().getComplement();
	}
}
