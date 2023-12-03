package com.fer.digitalno.obrazovanje.KidLingo.service.impl;

import com.fer.digitalno.obrazovanje.KidLingo.dao.GeneratedPictureRepository;
import com.fer.digitalno.obrazovanje.KidLingo.domain.GeneratedPicture;
import com.fer.digitalno.obrazovanje.KidLingo.service.GeneratedPictureService;
import com.fer.digitalno.obrazovanje.KidLingo.utils.ImageUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneratedPictureServiceImpl implements GeneratedPictureService {

    private final GeneratedPictureRepository generatedPictureRepository;

    @Override
    public void savePictureUrl(String word, String imageUrl) {
        generatedPictureRepository.save(GeneratedPicture.builder()
                        .word(word)
                        .imageUrl(imageUrl)
                        .build());
    }
}
