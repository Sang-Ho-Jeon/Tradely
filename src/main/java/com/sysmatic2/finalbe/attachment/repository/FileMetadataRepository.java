package com.sysmatic2.finalbe.attachment.repository;

import com.sysmatic2.finalbe.attachment.entity.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;


public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {

    Optional<FileMetadata> findByUploaderIdAndFileCategory(String uploaderId, String category);

    Optional<FileMetadata> findByFilePath(String filePath);

    Optional<FileMetadata> findByFileCategoryItemId(String strategyId);

    List<FileMetadata> findAllByFileCategoryItemId(String strategyId);

    List<FileMetadata> findAllByFilePathIn(List<String> filePaths);
}
