package com.fer.digitalno.obrazovanje.KidLingo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "generated_picture")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneratedPicture {

    @Id
    @GeneratedValue()
    private Long id;

    private String word;

    private byte[] imageData;

    // https://medium.com/shoutloudz/spring-boot-upload-and-download-images-using-jpa-b1c9ef174dc0
}
