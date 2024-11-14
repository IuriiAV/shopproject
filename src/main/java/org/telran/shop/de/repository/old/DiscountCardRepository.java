package org.telran.shop.de.repository.old;

import org.telran.shop.de.entity.DiscountCard;

import java.util.List;

@Deprecated
public interface DiscountCardRepository {

    List<DiscountCard> getAll();

    DiscountCard create(DiscountCard card);

    DiscountCard getById(String id);

    void deleteById(String id);

    void setExpired(String id);

    List<DiscountCard> filter(boolean expired);
}
