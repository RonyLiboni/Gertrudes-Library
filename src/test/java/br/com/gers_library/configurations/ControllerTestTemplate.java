package br.com.gers_library.configurations;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gers_library.repositories.customer.CustomerRepository;
import br.com.gers_library.repositories.employee.EmployeeRepository;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public abstract class ControllerTestTemplate {
	
	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	protected ObjectMapper objectMapper;
	@Autowired
	protected Flyway flyway;
	@Autowired
	protected CustomerRepository customerRepository;
	@Autowired
	protected EmployeeRepository employeeRepository;
	
	@BeforeEach
	void setup(){
		flyway.clean();
		flyway.migrate();
	}
}
