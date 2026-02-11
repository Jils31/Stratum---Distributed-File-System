package com.distributed_file_system.metadata_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(
        name = "blocks",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_file_block", columnNames = {"file_id", "block_index"})
        }
)
@Data
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "block_index", nullable = false)
    private Integer blockIndex;

    @Column(nullable = false)
    private Integer size;

    @Column(nullable = false, length = 64)
    private String checksum;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "file_id", foreignKey = @ForeignKey(name = "fk_blocks_file"))
    private FileEntity file;
}
