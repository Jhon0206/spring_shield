package dev.jhon0206.spring_shield.services;

import org.springframework.stereotype.Service;

import dev.jhon0206.spring_shield.entities.User;
import dev.jhon0206.spring_shield.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository repository;

  public User findByEmail(String email){
    return repository.findByEmail(email).orElseThrow();
  }
}
