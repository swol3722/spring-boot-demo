package dev.wolffcode.spring_boot_demo.service.impl;

import static dev.wolffcode.spring_boot_demo.common.Mapper.mapper;

import dev.wolffcode.spring_boot_demo.dto.User;
import dev.wolffcode.spring_boot_demo.persistance.repository.UserRepository;
import dev.wolffcode.spring_boot_demo.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> fetchAll() {
    return userRepository.findAll().stream()
        .map(mapper::mapUserEntityToUser)
        .collect(Collectors.toList());
  }

  @Override
  public void saveUser(User user) {
    userRepository.save(mapper.mapUserToUserEntity(user));
  }
}
