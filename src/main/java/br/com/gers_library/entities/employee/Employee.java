package br.com.gers_library.entities.employee;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.entities.library_user.LibraryUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee extends LibraryUser {
	@Column(nullable = false, length = 100)
	private String jobTitle;
	@Column(nullable = false)
	private LocalDate hireDate;
	
	@Builder
	public Employee(Long id, String fullName, String documentCpf, Address address, String jobTitle, LocalDate hireDate) {
		super(id, fullName, documentCpf, address);
		this.jobTitle = jobTitle;
		this.hireDate = hireDate;
	}
	
	
}
