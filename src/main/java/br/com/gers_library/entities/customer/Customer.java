package br.com.gers_library.entities.customer;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.gers_library.entities.library_user.Address;
import br.com.gers_library.entities.library_user.LibraryUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
@NoArgsConstructor
public class Customer extends LibraryUser {
	
	@Builder
	public Customer(Long id, String fullName, String documentCpf, Address address) {
		super(id, fullName, documentCpf, address);
	}
	
}
