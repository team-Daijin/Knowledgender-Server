package com.stac.daijin.domain.card.presentation.dto;


import com.stac.daijin.domain.card.CardCategory;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveCardRequest {
    private String title;
    private CardCategory category;
    private String content;
    private MultipartFile image;
}
