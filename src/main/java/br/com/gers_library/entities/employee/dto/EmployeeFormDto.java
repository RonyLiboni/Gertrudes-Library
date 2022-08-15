package br.com.gers_library.entities.employee.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.validation.cep.CepExists;
import br.com.gers_library.validation.document_cpf.DocumentCpfIsValid;
import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(example = "Naruto Uzumaki")
	private String fullName;
	
	@DocumentCpfIsValid
	@Schema(example = "379.365.510-50")
	private String documentCpf; 
	
	@CepExists
	@Schema(example = "82990-192")
	private String cep;
	
	@NotNull
	@Schema(example = "1")
	private Integer streetNumber;
	
	@Schema(example = "In front of a convenience store")
	private String complement;
	
	@NotBlank
	@Schema(example = "Operations Director")
	private String jobTitle;
	
	@NotNull
	@Schema(example = "2022-08-15")
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
