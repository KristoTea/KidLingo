package com.fer.digitalno.obrazovanje.KidLingo.rest;

import com.fer.digitalno.obrazovanje.KidLingo.service.GeneratedPictureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/picture")
public class GeneratedPictureController {

    private final GeneratedPictureService generatedPictureService;

    @PostMapping
    public ResponseEntity<?> saveGeneratedPictures(MultipartFile picture) {
        try {
            generatedPictureService.savePicture(picture);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
