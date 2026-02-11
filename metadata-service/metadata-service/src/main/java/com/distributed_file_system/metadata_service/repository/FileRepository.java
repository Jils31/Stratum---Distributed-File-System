package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
