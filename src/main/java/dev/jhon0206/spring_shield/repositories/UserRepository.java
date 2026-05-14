package dev.jhon0206.spring_shield.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.jhon0206.spring_shield.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles","roles.role"})
    Optional<User> findByEmail(String email);

}
