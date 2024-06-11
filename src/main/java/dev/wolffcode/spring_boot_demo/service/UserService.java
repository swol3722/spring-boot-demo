package dev.wolffcode.spring_boot_demo.service;

import dev.wolffcode.spring_boot_demo.dto.User;
import java.util.List;

public interface UserService {
  List<User> fetchAll();

  void saveUser(User user);
}
