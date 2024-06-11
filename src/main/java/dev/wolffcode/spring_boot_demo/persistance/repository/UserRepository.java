package dev.wolffcode.spring_boot_demo.persistance.repository;

import dev.wolffcode.spring_boot_demo.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {}
