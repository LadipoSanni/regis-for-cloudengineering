package com.ladiakinson.regis.usersservice;

import com.ladiakinson.regis.regisexception.UserAlreadyExistsException;
import com.ladiakinson.regis.regismodel.Users;
import com.ladiakinson.regis.regisrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users users) {
        // Check if user already exists by username or email
        Optional<Users> existingUser = userRepository.findByUsernameOrEmail(users.getUsername(), users.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with username or email already exists");
        }
        return userRepository.save(users);
    }
}

