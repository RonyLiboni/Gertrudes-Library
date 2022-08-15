package br.com.gers_library.entities.library_user;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(example = "82990-192")
	private String cep;
	
	@Column(nullable = false, length = 100)
	@Schema(example = "Rua Major Paulo Lessi")
	private String street;
	
	@Column(nullable = false, length = 100)
	@Schema(example = "1")
	private Integer streetNumber;
	
	@Schema(example = "In front of a convenience store")
	private String complement;
	
	@Column(nullable = false, length = 100)
	@Schema(example = "Cajuru")
	private String district;
	
	@Column(nullable = false, length = 100)
	@Schema(example = "Curitiba")
	private String city;
}
