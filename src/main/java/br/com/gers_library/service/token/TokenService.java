package br.com.gers_library.service.token;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.gers_library.entities.login.LoginFormDto;
import br.com.gers_library.entities.token.TokenDto;
import br.com.gers_library.entities.user.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${gerlibrary.jwt.expiration}")
	private String expiration;
	
	@Value("${gerlibrary.jwt.secret}")
	private String secret;
		
	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UUID getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return UUID.fromString(claims.getSubject());
	}
	
	public TokenDto createToken(LoginFormDto form, AuthenticationManager authManager) {
		return new TokenDto(buildToken(createAuthentication(form, authManager)), "Bearer");
	}

	private Authentication createAuthentication(LoginFormDto form, AuthenticationManager authManager) {
		return authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword()));
	}
	
	private String buildToken(Authentication authentication) {
		UserEntity user = (UserEntity) authentication.getPrincipal();
	
		return Jwts.builder()
				.setIssuer("Ger Library API")
				.setSubject(user.getUserId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + Long.parseLong(expiration)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
}
