package com.stac.daijin.domain.auth.domain.repository;

import com.stac.daijin.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

}
