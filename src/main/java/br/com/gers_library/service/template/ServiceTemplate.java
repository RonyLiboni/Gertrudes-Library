package br.com.gers_library.service.template;

public abstract class ServiceTemplate {
	
	protected String letStringOnlyWithNumbers(String string) {
		return string.replaceAll("[^0-9]", "");
	}
}
