package com.stac.daijin.domain.card.repository;

import com.stac.daijin.domain.card.Card;
import com.stac.daijin.domain.card.enums.CardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {
    List<Card> findByCategory(String category);

}
