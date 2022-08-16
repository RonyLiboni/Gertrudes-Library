package br.com.gers_library.validation.cep;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gers_library.configurations.ServiceTestTemplate;

class CepValidatorTest extends ServiceTestTemplate{
	
	@InjectMocks
	private CepValidator cepValidator;
	@Mock
	private ConstraintValidatorContext cvc;
	
	@Test
	void isValid_shouldReturnFalse_whenCepIsNull() {
		assertThat(cepValidator.isValid(null, cvc)).isEqualTo(false);
	}
	
	@Test
	void isValid_shouldReturnFalse_whenCepDoesntExist() {
		assertThat(cepValidator.isValid("151516", cvc)).isEqualTo(false);
	}
	
	@Test
	void isValid_shouldReturnTrue_whenCepExist() {
		assertThat(cepValidator.isValid("01001-000", cvc)).isEqualTo(true);
	}

}
