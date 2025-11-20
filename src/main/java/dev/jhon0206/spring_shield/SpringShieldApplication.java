package dev.jhon0206.spring_shield;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.jhon0206.spring_shield.entities.User;
import dev.jhon0206.spring_shield.repositories.UserRepository;

@SpringBootApplication
public class SpringShieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShieldApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder encoder){
		return args -> {
			if(repository.findByEmail("admin@shield.com").isEmpty()){
				User user = new User();
				user.setEmail("admin@shield.com");
				user.setNames("admin");
				user.setLastName("admin");
				user.setPassword(encoder.encode("123456"));
				
				repository.save(user);
			}
		};
	}
}
