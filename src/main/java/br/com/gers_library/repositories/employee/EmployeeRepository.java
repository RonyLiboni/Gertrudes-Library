package br.com.gers_library.repositories.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gers_library.entities.employee.Employee;
import br.com.gers_library.repositories.projections.HighestIncidenceCepProjection;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query(value = "SELECT cep, street, district, COUNT(cep) as cepCount "
			+ "FROM employees "
			+ "GROUP BY cep , street, district "
			+ "ORDER BY cepCount DESC ", nativeQuery = true)
	 List<HighestIncidenceCepProjection> getOrderedCepCount();
}
