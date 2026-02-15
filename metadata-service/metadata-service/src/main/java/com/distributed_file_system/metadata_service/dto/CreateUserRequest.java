package com.distributed_file_system.metadata_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotNull(message="Name is required")
    private String name;

    @NotNull(message="Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String passwordHash;
}
