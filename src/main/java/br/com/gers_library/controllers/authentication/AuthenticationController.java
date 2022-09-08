package br.com.gers_library.controllers.authentication;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gers_library.entities.login.LoginFormDto;
import br.com.gers_library.entities.token.TokenDto;
import br.com.gers_library.service.token.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication Endpoint", description = "Here, you will be able authenticate and get a token with your permissions.")
public class AuthenticationController {
	private final TokenService tokenService;
	private final AuthenticationManager authManager;

	@PostMapping
	@Operation(summary = "Get a token through your username and password.")
	@ApiResponses(value = {
		    @ApiResponse(responseCode= "201", description = "The token was created with success!"),
		    @ApiResponse(responseCode= "403", description = "You informed wrong username or password"),
		})
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginFormDto form) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tokenService.createToken(form, authManager));
	}		
}
