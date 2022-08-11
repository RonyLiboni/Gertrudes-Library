package br.com.gers_library.entities.library_user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
