package com.example.guide.connect.service;

import com.example.guide.connect.model.*;
import com.example.guide.connect.Repository.GuideRepository;
import com.example.guide.connect.Repository.TouristRepository;
import com.example.guide.connect.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TouristRepository touristRepository;

    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(String firstName, String lastName,
                         String email, String password, Role role) {

        // Check if email already exists
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }

        // Create Tourist or Guide based on role
        User user;
        if (role == Role.TOURIST) {
            user = new Tourist();
        } else if (role == Role.GUIDE) {
            user = new Guide();
        } else {
            throw new RuntimeException("Invalid role");
        }

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(role);
        user.setStatus(AccountStatus.ACTIVE);

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public void updateGuideProfile(String email, String biography,
                                   String languages, Double pricing) {

        Guide guide = (Guide) userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        guide.setBiography(biography);
        guide.setLanguages(languages);
        guide.setPricing(pricing);

        userRepository.save(guide);
    }
}