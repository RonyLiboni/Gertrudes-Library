package br.com.gers_library.repositories.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gers_library.entities.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
