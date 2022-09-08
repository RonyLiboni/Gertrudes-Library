package br.com.gers_library.entities.token;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
	
	@Schema(example = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiO...")
	private String token;
	@Schema(example = "Bearer")
	private String type;

}