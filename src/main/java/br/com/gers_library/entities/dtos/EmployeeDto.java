package br.com.gers_library.entities.dtos;

import java.time.LocalDate;

import br.com.gers_library.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	
	private String fullName;
	private String documentCpf;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String jobTitle;
	private LocalDate hireDate;
	
	public EmployeeDto(Employee employee) {
		this.fullName = employee.getFullName();
		this.documentCpf = employee.getDocumentCpf();
		this.cep = employee.getAddress().getCep();
		this.logradouro = employee.getAddress().getLogradouro();
		this.numero = employee.getAddress().getNumero();
		this.complemento = employee.getAddress().getComplemento();
		this.bairro = employee.getAddress().getBairro();
		this.cidade = employee.getAddress().getCidade();
		this.jobTitle = employee.getJobTitle();
		this.hireDate = employee.getHireDate();
	}

}
