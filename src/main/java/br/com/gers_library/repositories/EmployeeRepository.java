package br.com.gers_library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(value = "SELECT cep, street, district, COUNT(cep) as cep_count "
			+ "FROM employees "
			+ "GROUP BY cep "
			+ "ORDER BY cep_count DESC "
			+ "LIMIT 1", nativeQuery = true)
	 HighestIncidenceCepProjection getCepWithTheHighestIncidence();
}
