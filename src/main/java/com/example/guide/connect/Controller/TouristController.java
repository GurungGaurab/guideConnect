package com.example.guide.connect.Controller;

import com.example.guide.connect.model.User;
import com.example.guide.connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model){

        String email = authentication.getName();

        User user = userService.findByEmail(email);

        model.addAttribute("user", user);
        return "tourist/profile";



    }
}
