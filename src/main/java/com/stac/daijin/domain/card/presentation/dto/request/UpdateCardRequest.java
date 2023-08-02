package com.stac.daijin.domain.card.presentation.dto.request;

import com.stac.daijin.domain.card.CardCategory;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateCardRequest {
    private String title;
    private CardCategory category;
    private String content;
    private MultipartFile image;
}
