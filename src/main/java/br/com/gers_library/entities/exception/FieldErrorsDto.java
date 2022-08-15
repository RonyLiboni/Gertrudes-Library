package br.com.gers_library.entities.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldErrorsDto {
	
	@Schema(example = "DocumentCpf")
	private String field;
	
	@Schema(example = "You must inform a valid CPF!")
	private String error;
}
