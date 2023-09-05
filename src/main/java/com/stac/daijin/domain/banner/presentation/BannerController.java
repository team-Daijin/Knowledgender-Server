package com.stac.daijin.domain.banner.presentation;

import com.stac.daijin.domain.banner.presentation.dto.response.BannerListResponse;
import com.stac.daijin.domain.banner.service.QueryBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banner")
@RequiredArgsConstructor
public class BannerController {

    private final QueryBannerService queryBannerService;

    @GetMapping("/")
    public BannerListResponse getBannerList() {
        return queryBannerService.execute();
    }


}
