package br.com.gers_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gers_library.entities.employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
