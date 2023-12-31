package com.stac.daijin.domain.banner.presentation.dto.response;

import com.stac.daijin.domain.banner.domain.Banner;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BannerResponse {
    private String fileUrl;
    private String redirect;

    public static BannerResponse of(Banner banner) {
        return BannerResponse.builder()
                .fileUrl(banner.getFileUrl())
                .redirect(banner.getRedirect())
                .build();
    }
}
