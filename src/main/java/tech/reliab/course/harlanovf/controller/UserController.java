package tech.reliab.course.harlanovf.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import tech.reliab.course.harlanovf.entity.User;
import tech.reliab.course.harlanovf.model.UserRequest;
import java.util.List;
public interface UserController {
    ResponseEntity<User> createUser(@RequestBody UserRequest userRequest);
    ResponseEntity<Void> deleteUser(@PathVariable int id);
    ResponseEntity<User> getUserById(@PathVariable int id);
    ResponseEntity<List<User>> getAllUsers();
}