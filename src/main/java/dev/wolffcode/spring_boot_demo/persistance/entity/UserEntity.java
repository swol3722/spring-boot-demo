package dev.wolffcode.spring_boot_demo.persistance.entity;

import dev.wolffcode.spring_boot_demo.common.Gender;
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "first_name", length = 50, nullable = false)
  String firstName;

  @Column(name = "last_name", length = 50, nullable = false)
  String lastName;

  @Column(nullable = false)
  LocalDate birthday;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  Gender gender;

  @Column(length = 50)
  String email;
}
