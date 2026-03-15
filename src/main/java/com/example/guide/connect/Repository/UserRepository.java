package com.example.guide.connect.Repository;

import com.example.guide.connect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> { //SQL commands from JPA respository

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
