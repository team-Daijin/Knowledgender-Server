package com.stac.daijin.domain.banner.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BannerListResponse {
    private List<BannerResponse> bannerResponses;
}
