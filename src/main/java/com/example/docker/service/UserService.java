package com.example.docker.service;

import com.example.docker.dto.UserDTO;
import com.example.docker.entity.User;
import com.example.docker.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }

    public  User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(UUID id, UserDTO newUser) {
        User updatedUser = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user not found")
        );
        if (newUser.getName() != null) {
            updatedUser.setName(newUser.getName());
        }
        if (newUser.getEmail() != null) {
            updatedUser.setEmail(newUser.getEmail());
        }
        return userRepository.save(updatedUser);
    }
}
