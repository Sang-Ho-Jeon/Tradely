package com.sysmatic2.finalbe.attachment.controller;

import com.sysmatic2.finalbe.attachment.dto.FileMetadataDto;
import com.sysmatic2.finalbe.attachment.service.ProfileService;
import com.sysmatic2.finalbe.member.dto.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/files/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    /**
     * 프로필 파일 업로드 또는 업데이트
     *
     * @param file        업로드할 파일
     * @param userDetails  업로드한 사용자 ID (JWT 토큰에서 추출)
     * @return 업로드된 파일 메타데이터와 성공 메시지
     */
    @PostMapping
    public ResponseEntity<?> uploadProfileFile(@RequestParam("file") MultipartFile file,
                                               @AuthenticationPrincipal CustomUserDetails userDetails) {

        // uploaderId 추출 (로그인한 사람)
        String uploaderId = userDetails.getMemberId();


        FileMetadataDto fileMetadataDto = profileService.uploadOrUpdateProfileFile(file, uploaderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "fileId", fileMetadataDto.getId(),
                "fileUrl", fileMetadataDto.getFilePath(),
                "displayName", fileMetadataDto.getDisplayName(),
                "message", "File successfully uploaded"
        ));

    }

    /**
     * 프로필 파일 삭제
     *
     * @param fileId      삭제할 파일의 ID
     * @param userDetails  요청한 사용자 ID (JWT 토큰에서 추출)
     * @return 성공 메시지
     */
    @DeleteMapping("/{fileId}")
    public ResponseEntity<?> deleteProfileFile(@PathVariable Long fileId,
                                               @AuthenticationPrincipal CustomUserDetails userDetails) {

        // uploaderId 추출 (로그인한 사람)
        String uploaderId = userDetails.getMemberId();

        profileService.deleteProfileFile(fileId, uploaderId);

        return ResponseEntity.ok(Map.of(
                "fileId", fileId,
                "message", "File successfully deleted"
        ));

    }

    /**
     * 프로필 url 조회
     *
     * @param memberId  사용자 ID
     * @return 파일 메타데이터
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<Map<String, Object>> getProfileUrl(@PathVariable String memberId) {

//        // uploaderId 추출 (로그인한 사람)
//        String uploaderId = userDetails.getMemberId();

        // 프로필 메타데이터 조회
        Optional<FileMetadataDto> fileMetadataDto = profileService.getProfileUrl(memberId);

        // 응답 데이터 생성
        Map<String, Object> response = new HashMap<>();
        response.put("fileId", fileMetadataDto.map(FileMetadataDto::getId).orElse(null));
        response.put("fileUrl", fileMetadataDto.map(FileMetadataDto::getFilePath).orElse(null));
        response.put("displayName", fileMetadataDto.map(FileMetadataDto::getDisplayName).orElse("No display name"));
        response.put("category", fileMetadataDto.map(FileMetadataDto::getFileCategory).orElse("No category"));
        response.put("message", fileMetadataDto.isPresent() ? "File URL retrieved successfully" : "No profile URL found");

        return ResponseEntity.ok(response);

    }

}