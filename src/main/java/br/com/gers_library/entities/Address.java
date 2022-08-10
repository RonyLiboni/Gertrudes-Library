package br.com.gers_library.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
public class Address {
	
	@Column(nullable = false, length = 8)
	private String cep;
	
	@Column(nullable = false, length = 100)
	private String street;
	
	@Column(nullable = false, length = 100)
	private Integer streetNumber;
	
	private String complement;
	
	@Column(nullable = false, length = 100)
	private String district;
	
	@Column(nullable = false, length = 100)
	private String city;
}
