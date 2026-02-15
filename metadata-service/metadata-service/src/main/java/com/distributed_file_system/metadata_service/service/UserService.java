package com.distributed_file_system.metadata_service.service;

import com.distributed_file_system.metadata_service.dto.CreateUserRequest;
import com.distributed_file_system.metadata_service.dto.CreateUserResponse;
import com.distributed_file_system.metadata_service.entity.User;
import com.distributed_file_system.metadata_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserResponse createUser(CreateUserRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setDeletedAt(null);

        user.setCreatedAt(OffsetDateTime.now());
        user.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));

        userRepository.save(user);

        CreateUserResponse response = new CreateUserResponse();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMessage("User created successfully");

        return response;
    }
}
