package br.com.gers_library.entities.employee.dto;

import java.time.LocalDate;

import br.com.gers_library.entities.employee.Employee;
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
public class EmployeeDto {
	
	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "Naruto Uzumaki")
	private String fullName;
	
	@Schema(example = "379.365.510-50")
	private String documentCpf;
	
	@Schema(example = "82990-192")
	private String cep;
	
	@Schema(example = "Rua Major Paulo Lessi")
	private String street;
	
	@Schema(example = "1")
	private Integer streetNumber;
	
	@Schema(example = "In front of a convenience store")
	private String complement;
	
	@Schema(example = "Cajuru")
	private String district;
	
	@Schema(example = "Curitiba")
	private String city;
	
	@Schema(example = "Operations Director")
	private String jobTitle;
	
	@Schema(example = "2022-08-15")
	private LocalDate hireDate;
	
	public EmployeeDto(Employee employee) {
		this.id = employee.getId();
		this.fullName = employee.getFullName();
		this.documentCpf = employee.getDocumentCpf();
		this.cep = employee.getAddress().getCep();
		this.street = employee.getAddress().getStreet();
		this.streetNumber = employee.getAddress().getStreetNumber();
		this.complement = employee.getAddress().getComplement();
		this.district = employee.getAddress().getDistrict();
		this.city = employee.getAddress().getCity();
		this.jobTitle = employee.getJobTitle();
		this.hireDate = employee.getHireDate();
		
	}

}
