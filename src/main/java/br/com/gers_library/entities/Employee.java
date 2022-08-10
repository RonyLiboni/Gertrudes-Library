package br.com.gers_library.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "employees")
public class Employee extends LibraryUser {
	@Column(nullable = false, length = 100)
	private String jobTitle;
	@Column(nullable = false)
	private LocalDate hireDate;
}
