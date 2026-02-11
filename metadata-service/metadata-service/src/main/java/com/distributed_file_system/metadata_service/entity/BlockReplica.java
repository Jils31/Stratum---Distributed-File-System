package com.distributed_file_system.metadata_service.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(
        name = "block_replicas",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_block_datanode", columnNames = {"block_id", "datanode_id"})
        }
)
public class BlockReplica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "block_id", foreignKey = @ForeignKey(name = "fk_replica_block"))
    private Block block;

    @ManyToOne(optional = false)
    @JoinColumn(name = "datanode_id", foreignKey = @ForeignKey(name = "fk_replica_datanode"))
    private DataNode dataNode;
}
