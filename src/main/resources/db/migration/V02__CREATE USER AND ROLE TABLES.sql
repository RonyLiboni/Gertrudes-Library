CREATE TABLE users (
  user_id varbinary(36) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(150) NOT NULL UNIQUE KEY,
  PRIMARY KEY (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE role (
  role_id bigint NOT NULL AUTO_INCREMENT,
  role_name varchar(255) NOT NULL UNIQUE KEY,
  PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO role (role_id, role_name) 
VALUES (1, 'ROLE_ADMIN');

INSERT INTO role (role_id, role_name) 
VALUES (2, 'ROLE_USER');

CREATE TABLE users_roles (
  user_entity_user_id varbinary(36) NOT NULL,
  roles_role_id bigint NOT NULL,
  FOREIGN KEY (user_entity_user_id) REFERENCES users (user_id),
  FOREIGN KEY (roles_role_id) REFERENCES role (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO users (user_id, password, username) 
VALUES (UUID_TO_BIN('15b53dce-32c5-475d-aa1c-7e0fa1682b24'), '$2a$12$Ei0ZtHu1K37/RTMgP97Uiefw5up03sy6dy1EDjlH4wEglrxSi/v3q', 'rony');

INSERT INTO users_roles (user_entity_user_id, roles_role_id)
VALUES (UUID_TO_BIN('15b53dce-32c5-475d-aa1c-7e0fa1682b24'), 1);