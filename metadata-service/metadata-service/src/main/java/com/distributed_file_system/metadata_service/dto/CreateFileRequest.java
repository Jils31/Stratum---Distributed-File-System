package com.distributed_file_system.metadata_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFileRequest {
    @NotNull(message="File name is required")
    private String fileName;

    @NotNull(message="File size is required")
    private Long fileSize;
}
