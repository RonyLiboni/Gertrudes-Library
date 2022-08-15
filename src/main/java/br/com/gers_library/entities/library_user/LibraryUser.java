package br.com.gers_library.entities.library_user;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class LibraryUser {
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Schema(example = "1")
	private Long id;
	@Column(nullable = false)
	@Schema(example = "Naruto Uzumaki")
	private String fullName;
	@Column(nullable = false, length = 11)
	@Schema(example = "379.365.510-50")
	private String documentCpf;
	@Embedded
	private Address address;
	
}
