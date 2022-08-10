package br.com.gers_library.entities.customer;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.gers_library.entities.library_user.LibraryUser;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@Table(name = "customers")
public class Customer extends LibraryUser {
	
}
