package br.com.gers_library.validation.document_cpf;

import static org.assertj.core.api.Assertions.assertThat;

import javax.validation.ConstraintValidatorContext;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import br.com.gers_library.service.employee.ServiceTestTemplate;

class DocumentCpfValidatorTest extends ServiceTestTemplate{
	
	@InjectMocks
	private DocumentCpfValidator documentCpfValidator;
	@Mock
	private ConstraintValidatorContext cvc;
	
	@Test
	void isValid_shouldReturnFalse_whenDocumentCpfIsNull() {
		assertThat(documentCpfValidator.isValid(null, cvc)).isEqualTo(false);
	}
	
	@Test
	void isValid_shouldReturnFalse_whenCepDoesntExist() {
		assertThat(documentCpfValidator.isValid("69546264554", cvc)).isEqualTo(false);
	}
	
	@Test
	void isValid_shouldReturnTrue_whenCepExist() {
		assertThat(documentCpfValidator.isValid("670.824.710-09", cvc)).isEqualTo(true);
	}

}
