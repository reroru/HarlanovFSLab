package tech.reliab.course.harlanovf.service;

import tech.reliab.course.harlanovf.entity.User;
import tech.reliab.course.harlanovf.model.UserRequest;

import java.util.List;

public interface UserService {
    User createUser(UserRequest userRequest);

    User getUser(int id);

    void deleteUser(int id);

    List<User> getAllUsers();
}