package com.ladiakinson.regis.regisrepository;

import com.ladiakinson.regis.regismodel.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);

    Optional<Users> findByUsernameOrEmail(String username, String email);
}

