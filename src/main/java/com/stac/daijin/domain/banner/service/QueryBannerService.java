package com.stac.daijin.domain.banner.service;

import com.stac.daijin.domain.banner.domain.type.State;
import com.stac.daijin.domain.banner.presentation.dto.response.BannerListResponse;
import com.stac.daijin.domain.banner.presentation.dto.response.BannerResponse;
import com.stac.daijin.domain.banner.domain.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryBannerService {
    private final BannerRepository bannerRepository;

    @Transactional(readOnly = true)
    public BannerListResponse execute() {
        return new BannerListResponse(
                bannerRepository.findAllByState(State.ACTIVE)
                .stream()
                .map(BannerResponse::of)
                .collect(Collectors.toList()));
    }
}
