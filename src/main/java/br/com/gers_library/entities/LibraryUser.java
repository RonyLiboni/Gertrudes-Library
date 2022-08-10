package br.com.gers_library.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class LibraryUser {
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Column(nullable = false)
	private String fullName;
	@Column(nullable = false, length = 11, unique = true)
	private String documentCpf;
	@Embedded
	private Address address;
	
}
