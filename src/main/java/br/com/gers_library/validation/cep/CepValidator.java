package br.com.gers_library.validation.cep;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import br.com.gers_library.http.ViaCepAddress;

public class CepValidator implements ConstraintValidator<CepExists, String>{
	
	private final String url = "https://viacep.com.br/ws/";
	
	@Override
	public boolean isValid(String cep, ConstraintValidatorContext context) {
		cep = cep.replaceAll("[^0-9]", "");
		
		if (getStatusCodeFromViaCep(cep) == HttpStatus.OK)
			return true;
				
		return false;
	}
	
	private HttpStatus getStatusCodeFromViaCep(String cep) {
		return new RestTemplate().getForEntity(url+ cep + "/json/", ViaCepAddress.class).getStatusCode();
	}

}