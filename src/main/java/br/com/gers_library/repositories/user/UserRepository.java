package br.com.gers_library.repositories.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gers_library.entities.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
}
