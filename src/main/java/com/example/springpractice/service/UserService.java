package com.example.springpractice.service;

import com.example.springpractice.config.SecurityConfig;
import com.example.springpractice.dto.NewUserRequest;
import com.example.springpractice.dto.UserResponse;
import com.example.springpractice.model.User;
import com.example.springpractice.model.UserRole;
import com.example.springpractice.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;

    public User getUserByEmail(String email) {
        Optional<User> userToFind = repo.findByEmail(email);

        if (userToFind.isEmpty())
            throw new NotFoundException(String.format("No account Exist with this email: %s.", email));

        return userToFind.get();
    }

    public UserResponse createNewUser(NewUserRequest newUserData) {
        String id = UUID.randomUUID().toString();
        String hashedPassword = SecurityConfig.passwordEncoder
                .encode(newUserData.password());

        User newUser = new User(
                id, newUserData.name(), newUserData.email(),
                hashedPassword, UserRole.USER);

        User user = repo.save(newUser);
        return new UserResponse(user.id(), user.name(), user.email());
    }

}
