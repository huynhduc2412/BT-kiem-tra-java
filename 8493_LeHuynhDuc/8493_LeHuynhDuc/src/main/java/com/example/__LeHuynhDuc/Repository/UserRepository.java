package com.example.__LeHuynhDuc.Repository;

import com.example.__LeHuynhDuc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
