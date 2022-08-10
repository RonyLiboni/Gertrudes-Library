package br.com.gers_library.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class EmployeeFormDto {
	
	@NotBlank
	private String fullName;
	@NotBlank
	private String documentCpf;
	@NotBlank 
	private String cep;
	@NotBlank
	private Integer numero;
	private String complemento;
	@NotBlank
	private String jobTitle;
	@NotNull
	private LocalDate hireDate;
	
	public EmployeeFormDto(Employee employee) {
		this.fullName = employee.getFullName();
		this.documentCpf = employee.getDocumentCpf();
		this.cep = employee.getAddress().getCep();
		this.jobTitle = employee.getJobTitle();
		this.hireDate = employee.getHireDate();
		this.numero = employee.getAddress().getNumero();
		this.complemento = employee.getAddress().getComplemento();
	}

}
