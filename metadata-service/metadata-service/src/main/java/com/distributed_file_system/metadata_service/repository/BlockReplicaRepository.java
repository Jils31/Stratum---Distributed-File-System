package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.BlockReplica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockReplicaRepository extends JpaRepository<BlockReplica, Long> {
}
