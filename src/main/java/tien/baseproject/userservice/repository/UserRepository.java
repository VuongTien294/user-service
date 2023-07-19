package tien.baseproject.userservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tien.baseproject.userservice.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
