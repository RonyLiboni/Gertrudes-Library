package br.com.gers_library.entities.login;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginFormDto {
	
	@NotBlank
	@Schema(example = "Rony")
	private String username;
	@NotBlank
	@Schema(example = "123456")
	private String password;
}
