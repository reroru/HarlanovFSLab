package tech.reliab.course.harlanovf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.harlaanovf.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(int id);

    void deleteById(int id);
}