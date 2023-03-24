//package com.pickpack.chatservice.controller;
//
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.ObjectMetadata;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/upload")
//@RequiredArgsConstructor
//public class FileUploadController {
//
//    private final AmazonS3Client amazonS3Client;
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    //TODO member이미지 등록도 알아서 추가해야함
//    @PostMapping("/chat")
//    public ResponseEntity<String> imgFileUpload(@RequestPart MultipartFile file) {
//        try {
//            String fileName=file.getOriginalFilename();
//            String fileUrl= "https://" + bucket + "/test" +fileName;
//            ObjectMetadata metadata= new ObjectMetadata();
//            metadata.setContentType(file.getContentType());
//            metadata.setContentLength(file.getSize());
//            amazonS3Client.putObject(bucket,fileName,file.getInputStream(),metadata);
//            return ResponseEntity.ok(fileUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//}