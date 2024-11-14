package org.telran.shop.de.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

@Repository
public interface DiscountCardJpaRepository extends JpaRepository<DiscountCard, String> {

    @Query("SELECT card FROM DiscountCard card WHERE card.expired =:expired ")
    List<DiscountCard> filter(boolean expired);

}
