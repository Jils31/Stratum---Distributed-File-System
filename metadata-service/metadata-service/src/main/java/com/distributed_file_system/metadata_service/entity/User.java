package com.distributed_file_system.metadata_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="password_hash",nullable = false)
    private String passwordHash;

    @Column(name="deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name="created_at", nullable = false)
    private OffsetDateTime createdAt;
}
