package com.example.guide.connect.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {

        String role = authentication.getAuthorities().iterator().next().getAuthority();

        if(role.equals("ROLE_TOURIST")) {
            return "redirect:/tourist/dashboard";
        } else if(role.equals("ROLE_GUIDE")) {
            return "redirect:/guide/dashboard";
        } else if(role.equals("ROLE_ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/login";
    }

    @GetMapping("/tourist/dashboard")
    public String touristDashboard(){
        return "tourist/dashboard";
    }
    @GetMapping("/guide/dashboard")
    public String guideDashboard(){
        return "guide/dashboard";
    }
    @GetMapping("/admin/dashboard")
    public String adminDashboard(){
        return "admin/dashboard";
    }
}
