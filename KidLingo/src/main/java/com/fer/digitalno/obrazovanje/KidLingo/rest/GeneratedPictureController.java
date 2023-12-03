package com.fer.digitalno.obrazovanje.KidLingo.rest;

import com.fer.digitalno.obrazovanje.KidLingo.dto.SavePicture;
import com.fer.digitalno.obrazovanje.KidLingo.service.GeneratedPictureService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/picture")
public class GeneratedPictureController {

    private final GeneratedPictureService generatedPictureService;

    @PostMapping
    public ResponseEntity<?> saveGeneratedPictures(@RequestBody SavePicture savePicture) {
        generatedPictureService.savePictureUrl(savePicture.word(), savePicture.imageUrl());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
