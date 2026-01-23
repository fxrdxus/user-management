package com.example.userManagement.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userManagement.dto.UserRequest;
import com.example.userManagement.entity.User;
import com.example.userManagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository = null;
    private final PasswordEncoder passwordEncoder = null;

    // Create
    public User create(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole("USER");
        return userRepository.save(user);
    }

    // Read all
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Read by id
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update
    public User update(Long id, UserRequest request) {
        User user = findById(id);
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    // Delete
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
