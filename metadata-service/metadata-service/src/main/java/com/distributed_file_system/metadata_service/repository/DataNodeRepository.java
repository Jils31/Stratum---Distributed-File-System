package com.distributed_file_system.metadata_service.repository;

import com.distributed_file_system.metadata_service.entity.DataNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataNodeRepository extends JpaRepository<DataNode, Long> {
}
