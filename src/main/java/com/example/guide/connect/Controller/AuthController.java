package com.example.guide.connect.Controller;

import com.example.guide.connect.model.Role;
import com.example.guide.connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthController {

    @Autowired
    private UserService userService; //gets everything from UserService class (apply the rules here)

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login"; // looks for templates/auth/login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "auth/register"; // looks for templates/auth/register.html
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam Role role,
            Model model) {

        try {
            userService.register(firstName, lastName, email, password, role);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "auth/register";
        }
    }
}
