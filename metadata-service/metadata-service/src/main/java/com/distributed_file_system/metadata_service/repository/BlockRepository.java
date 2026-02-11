package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
