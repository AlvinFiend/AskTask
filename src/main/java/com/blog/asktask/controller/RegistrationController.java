package com.blog.asktask.controller;

import com.blog.asktask.domain.Role;
import com.blog.asktask.domain.User;
import com.blog.asktask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;

/**
 * @author Alvin
 **/

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String saveUser(User user, Map<String, Object> model){
        User userFromDb = userService.getByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));

        userService.save(user);

        return "redirect:/login";
    }
}
