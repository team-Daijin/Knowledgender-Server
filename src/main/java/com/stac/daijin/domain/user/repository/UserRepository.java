package com.stac.daijin.domain.user.repository;

import com.stac.daijin.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByAccountId(String accountId);

    Boolean existsByAccountId(String accountId);

    void deleteByAccountId(String accountId);
}
