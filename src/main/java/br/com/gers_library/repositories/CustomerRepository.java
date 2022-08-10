package br.com.gers_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gers_library.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
