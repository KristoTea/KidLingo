package com.fer.digitalno.obrazovanje.KidLingo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "generated_picture")
@Builder
public class GeneratedPicture {

    @Id
    @GeneratedValue()
    private Long id;

    private String word;

    private String type;

    private byte[] imageData;
}
