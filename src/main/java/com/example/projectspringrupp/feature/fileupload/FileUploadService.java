package com.example.projectspringrupp.feature.fileupload;

import com.example.projectspringrupp.feature.fileupload.dto.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {
    // Upload single file
    FileUploadResponse upload(MultipartFile file);

    // Delete
    void deleteByFileName(String fileName);
}
