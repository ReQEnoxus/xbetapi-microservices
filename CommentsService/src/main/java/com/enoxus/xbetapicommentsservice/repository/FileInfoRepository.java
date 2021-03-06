package com.enoxus.xbetapicommentsservice.repository;

import com.enoxus.xbetapicommentsservice.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    Optional<FileInfo> findFirstByStorageFileName(String storageFileName);
}