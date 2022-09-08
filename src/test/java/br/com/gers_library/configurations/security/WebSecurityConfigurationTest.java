package br.com.gers_library.configurations.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.gers_library.filters.TokenAuthenticationFilter;
import br.com.gers_library.repositories.user.UserRepository;
import br.com.gers_library.service.token.TokenService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@Profile("test")
public class WebSecurityConfigurationTest {
	
	private final UserRepository userRepository;
	private final TokenService tokenService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	} 
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
            .authorizeRequests()
            .antMatchers("/**")
            .permitAll()
            .and()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    		.and().addFilterBefore(new TokenAuthenticationFilter(tokenService, userRepository), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
	
}
