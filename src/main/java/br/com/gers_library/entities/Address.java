package br.com.gers_library.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
public class Address {
	
	@Size(min = 8, max = 8)
	private String cep;
	
	private String logradouro;
	
	@Size(max = 5)
	private Integer numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
}
