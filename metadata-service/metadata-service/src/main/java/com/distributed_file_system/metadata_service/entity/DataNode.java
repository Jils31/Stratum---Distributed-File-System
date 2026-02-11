package com.distributed_file_system.metadata_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(
        name = "datanodes",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_host_port", columnNames = {"host", "port"})
        }
)
@Data
public class DataNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private Integer port;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "last_heartbeat_at")
    private OffsetDateTime lastHeartbeatAt;

    @Column(name = "capacity_bytes", nullable = false)
    private Long capacityBytes;

    @Column(name = "used_bytes", nullable = false)
    private Long usedBytes;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
