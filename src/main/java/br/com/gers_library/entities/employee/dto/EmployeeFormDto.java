package br.com.gers_library.entities.employee.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.validation.cep.CepExists;
import br.com.gers_library.validation.document_cpf.DocumentCpfIsValid;
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
	@DocumentCpfIsValid
	private String documentCpf; 
	@CepExists
	private String cep;
	@NotNull
	private Integer streetNumber;
	private String complement;
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
		this.streetNumber = employee.getAddress().getStreetNumber();
		this.complement = employee.getAddress().getComplement();
	}

}
