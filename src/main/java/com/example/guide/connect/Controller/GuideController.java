package com.example.guide.connect.Controller;

import com.example.guide.connect.model.User;
import com.example.guide.connect.model.Guide;
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
@RequestMapping("/guide")
public class GuideController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {

        String email = authentication.getName();
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        return "guide/profile";

    }

    @GetMapping("/profile/edit")
    public String editProfile(Authentication authentication, Model model) {
        String email = authentication.getName();
        Guide guide = (Guide) userService.findByEmail(email);
        model.addAttribute("guide", guide);
        return "guide/edit-profile";
    }

    @PostMapping("/profile/edit")
    public String updateProfile(
            Authentication authentication,
            @RequestParam String biography,
            @RequestParam String languages,
            @RequestParam Double pricing) {

        String email = authentication.getName();
        userService.updateGuideProfile(email, biography, languages, pricing);
        return "redirect:/guide/profile";
    }


}
