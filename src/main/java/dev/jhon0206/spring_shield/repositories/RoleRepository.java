package dev.jhon0206.spring_shield.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jhon0206.spring_shield.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Short> {

}
