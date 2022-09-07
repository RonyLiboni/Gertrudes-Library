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
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	private final TokenService tokenService;
	private final AuthenticationManager authManager;

	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginFormDto form) {
		return ResponseEntity.status(HttpStatus.OK).body(tokenService.createToken(form, authManager));
	}		
}
