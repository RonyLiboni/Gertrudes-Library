CREATE TABLE customers
(
   id bigint AUTO_INCREMENT NOT NULL,
   document_cpf varchar (11) NOT NULL,
   full_name varchar (255) NOT NULL,
   cep varchar (8) NOT NULL,
   street varchar (100) NOT NULL,
   street_number int NOT NULL,
   city varchar (100) NOT NULL,
   complement varchar (255) DEFAULT NULL,
   district varchar (100) NOT NULL,
   PRIMARY KEY (id)
)
ENGINE= InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE employees
(
   id bigint AUTO_INCREMENT NOT NULL,
   document_cpf varchar (11) NOT NULL,
   full_name varchar (255) NOT NULL,
   hire_date date NOT NULL,
   job_title varchar (100) NOT NULL,
   cep varchar (8) NOT NULL,
   street varchar (100) NOT NULL,
   street_number int NOT NULL,
   city varchar (100) NOT NULL,
   complement varchar (255) DEFAULT NULL,
   district varchar (100) NOT NULL,
   PRIMARY KEY (id)
)
ENGINE= InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE hibernate_sequences
(
   sequence_name varchar (255) NOT NULL,
   next_val bigint DEFAULT NULL,
   PRIMARY KEY (sequence_name)
)
ENGINE= InnoDB DEFAULT CHARSET= utf8mb4 COLLATE= utf8mb4_0900_ai_ci;