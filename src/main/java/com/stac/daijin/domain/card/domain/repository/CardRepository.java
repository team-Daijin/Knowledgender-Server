package com.stac.daijin.domain.card.domain.repository;

import com.stac.daijin.domain.card.domain.Card;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    List<Card> findAllByCategory(String category, Sort sort);

}
