package com.distributed_file_system.metadata_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(
        name="files",
        uniqueConstraints = {
                @UniqueConstraint(name="unique_user_file", columnNames = {"user_id", "file_name"})
        }
)
@Data
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="file_name",nullable = false)
    private String fileName;

    @Column(name="file_size",nullable = false)
    private Long fileSize;

    @Column(name="block_size", nullable = false)
    private Integer blockSize;

    @Column(name="total_blocks", nullable = false)
    private Integer totalBlocks;

    @Column(nullable = false, length=20)
    private String status;

    @Column(name="deleted_at")
    private OffsetDateTime deletedAt;

    @Column(name="created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_files_user"))
    private User user;
}
