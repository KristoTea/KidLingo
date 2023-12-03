package com.fer.digitalno.obrazovanje.KidLingo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "generated_picture")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratedPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;

    private String imageUrl;
}
