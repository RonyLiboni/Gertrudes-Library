package br.com.gers_library.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep-consummer", url = "https://viacep.com.br/ws/")
public interface CepConsumerFeign {
	
	@GetMapping(value = "/{cep}/json/")
	public ResponseEntity<ViaCepAddress> getFullAddres(@PathVariable("cep") String cep); 

}
