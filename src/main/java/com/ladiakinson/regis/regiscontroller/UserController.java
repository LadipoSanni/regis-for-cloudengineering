package com.ladiakinson.regis.regiscontroller;

import com.ladiakinson.regis.regismodel.Users;
import com.ladiakinson.regis.usersservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(Users users, Model model) {
        userService.registerUser(users);
        return "redirect:/users/login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
