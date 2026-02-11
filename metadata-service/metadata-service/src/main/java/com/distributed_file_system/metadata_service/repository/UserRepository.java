package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
