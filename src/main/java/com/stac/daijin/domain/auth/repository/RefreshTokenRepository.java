package com.stac.daijin.domain.auth.repository;

import com.stac.daijin.domain.auth.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {

}
