package com.stac.daijin.domain.banner.presentation.dto.response;

import com.stac.daijin.domain.banner.Banner;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class BannerResponse {
    private UUID id;
    private String fileUrl;
    private String redirect;

    public static BannerResponse of(Banner banner) {
        return BannerResponse.builder()
                .fileUrl(banner.getFileUrl())
                .redirect(banner.getRedirect())
                .build();
    }
}
