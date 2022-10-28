package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
//=======================================================

//          ОТОБРАЖАЕТСЯ ЮЗЕР СО ВСЕМИ ПОЛЯМИ

    @GetMapping("/user")
    public String getUserPage(Authentication auth, Model model) {
        User user = (User) auth.getPrincipal();
        model.addAttribute("user", userService.loadUserByUsername(user.getUsername()));
        return "user";
    }


//=======================================================
}
