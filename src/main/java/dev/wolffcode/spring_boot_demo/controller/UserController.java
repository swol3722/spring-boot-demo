package dev.wolffcode.spring_boot_demo.controller;

import dev.wolffcode.spring_boot_demo.dto.User;
import dev.wolffcode.spring_boot_demo.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("")
  public List<User> getAllUsers() {
    return userService.fetchAll();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  public void createNewUser(@RequestBody User user) {
    userService.saveUser(user);
  }
}
