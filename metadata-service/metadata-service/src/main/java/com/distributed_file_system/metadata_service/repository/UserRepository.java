package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    //To check if the user exists by the email or not

    boolean existsByEmail(String email);
}
