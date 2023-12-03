package com.fer.digitalno.obrazovanje.KidLingo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface GeneratedPictureService {

    void savePictureUrl(String word, String pictureUrl);
}
