package br.com.gers_library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GersLibraryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GersLibraryApplication.class, args);
	}

}
