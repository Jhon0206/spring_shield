package dev.jhon0206.spring_shield;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.jhon0206.spring_shield.entities.Role;
import dev.jhon0206.spring_shield.entities.User;
import dev.jhon0206.spring_shield.entities.UserRoles;
import dev.jhon0206.spring_shield.repositories.RoleRepository;
import dev.jhon0206.spring_shield.repositories.UserRepository;
import dev.jhon0206.spring_shield.repositories.UserRolesRepository;

@SpringBootApplication
public class SpringShieldApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringShieldApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository,
      UserRolesRepository userRolesRepository, PasswordEncoder encoder) {
    return args -> {
      Role adminRole = new Role();
      if(roleRepository.count() == 0){
        adminRole.setName("ADMIN");
        adminRole = roleRepository.save(adminRole);
      }
      createAdminUserIfNotExists(userRepository, encoder);
      assignAdminRole(userRepository, userRolesRepository, adminRole);
    };
  }

  private void createAdminUserIfNotExists(UserRepository userRepository, PasswordEncoder encoder) {
    if (userRepository.findByEmail("admin@shield.com").isEmpty()) {
      User user = new User();
      user.setEmail("admin@shield.com");
      user.setNames("admin");
      user.setLastName("admin");
      user.setPassword(encoder.encode("123456"));
      userRepository.save(user);
    }
  }

  private void assignAdminRole(UserRepository userRepository, UserRolesRepository userRolesRepository, Role adminRole) {    
      UserRoles userRoles = new UserRoles();
      userRoles.setUser(userRepository.findByEmail("admin@shield.com").orElseThrow());
      userRoles.setRole(adminRole);
      userRolesRepository.save(userRoles);
  }
}
