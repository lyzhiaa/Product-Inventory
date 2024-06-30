package com.example.projectspringrupp.feature.user;

import com.example.projectspringrupp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserPhone(String userPhone);
    boolean existsByUserPhone(String userPhone);
}
