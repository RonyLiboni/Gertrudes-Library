package br.com.gers_library.validation.cep;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.gers_library.http.ViaCepAddress;
import br.com.gers_library.service.template.ServiceTemplate;

public class CepValidator extends ServiceTemplate implements ConstraintValidator<CepExists, String>{
	
	private final String url = "https://viacep.com.br/ws/";
	
	@Override
	public boolean isValid(String cep, ConstraintValidatorContext context) {
		if (doesCepExist(cep) == true)
			return true;
				
		return false;
	}
	
	private boolean doesCepExist(String cep) {		
		if(cep == null)
			return false;
		
		cep = letStringOnlyWithNumbers(cep);
	
		if (cep.length() != 8)
			return false;
		
		try {
			return new RestTemplate().getForEntity(url+ cep + "/json/", ViaCepAddress.class).getBody().getLocalidade() != null;
		} catch (RestClientException e) {
			return false;
		}
	}

}