package com.stac.daijin.domain.card.presentation.dto.request;

import com.stac.daijin.global.annotation.CardCategoryValid;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveCardRequest {
    private String title;
    @CardCategoryValid
    private String category;
    private String content;
    private MultipartFile thumbnail;
    private MultipartFile image;
}
