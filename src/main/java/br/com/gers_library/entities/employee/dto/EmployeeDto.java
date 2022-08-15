package br.com.gers_library.entities.employee.dto;

import java.time.LocalDate;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.entities.library_user.LibraryUser;
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
	
	private Long id;
	private String fullName;
	private String documentCpf;
	private String cep;
	private String street;
	private Integer streetNumber;
	private String complement;
	private String district;
	private String city;
	private String jobTitle;
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
