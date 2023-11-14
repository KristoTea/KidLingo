package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.GeneratedPictureRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.GeneratedPicture;
import com.fer.digitalno.obrazovanje.KidLingo.service.GeneratedPictureService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GeneratedPictureServiceImpl implements GeneratedPictureService {

    private GeneratedPictureRepository generatedPictureRepository;

    @Override
    public void savePicture(MultipartFile picture) {
        try {
            generatedPictureRepository.save(GeneratedPicture.builder()
                    .word(picture.getOriginalFilename())
                    .type(picture.getContentType())
                    .imageData(ImageUtil.compressImage(picture.getBytes())).build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public byte[] getPictureByWord(String word) {
        Optional<GeneratedPicture> generatedPicture = generatedPictureRepository.findByWord(word);
        return generatedPicture.map(picture -> ImageUtil
                .decompressImage(picture.getImageData())).orElse(null);
    }
}
