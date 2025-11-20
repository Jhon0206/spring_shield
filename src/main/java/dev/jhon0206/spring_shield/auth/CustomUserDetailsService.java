package dev.jhon0206.spring_shield.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.jhon0206.spring_shield.services.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserService service;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      return new CustomUserDetails(service.findByEmail(username));
    } catch (UsernameNotFoundException e) {
      throw new UsernameNotFoundException(String.format("User: %s, not found", username));
    }
  }

}
