package com.stac.daijin.domain.banner.repository;

import com.stac.daijin.domain.banner.domain.Banner;
import com.stac.daijin.domain.banner.domain.type.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BannerRepository extends JpaRepository<Banner, UUID> {
    List<Banner> findAllByState(State state);
}
