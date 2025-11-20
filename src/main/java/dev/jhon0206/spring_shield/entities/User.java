package dev.jhon0206.spring_shield.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 50)
  private String names;
  @Column(nullable = false, length = 100, name = "last_name")
  private String lastName;
  @Column(nullable = false, length = 50, unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<UserRoles> roles;
}
