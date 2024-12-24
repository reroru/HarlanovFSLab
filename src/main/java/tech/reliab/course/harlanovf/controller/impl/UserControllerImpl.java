package tech.reliab.course.harlanovf.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.harlanovf.controller.UserController;
import tech.reliab.course.harlanovf.entity.User;
import tech.reliab.course.harlanovf.model.UserRequest;
import tech.reliab.course.harlanovf.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    @PostMapping
    public ResponseEntity<User> createUser(UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(int id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}