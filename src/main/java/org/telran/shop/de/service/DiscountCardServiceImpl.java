package org.telran.shop.de.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.exception.CardNotFoundException;
import org.telran.shop.de.repository.DiscountCardJpaRepository;

import java.util.List;

@Service
public class DiscountCardServiceImpl implements DiscountCardService {

    @Autowired
    private DiscountCardJpaRepository repository;

//    @Autowired
//    @Qualifier("dcrepository")
//    private DiscountCardRepository repository;

//    @Autowired
//    @Qualifier("discountCardInMemoryRepository")
//    private DiscountCardRepository iMrepository;

    @Override
    public List<DiscountCard> getAll() {
        return repository.findAll();
    }

    @Override
    public DiscountCard create(DiscountCard card) {
        return repository.save(card);
    }

    @Override
    public DiscountCard getById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CardNotFoundException("Card with id " + id + " not found"));
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void setExpired(String id) {
        DiscountCard entity = getById(id);
        entity.setExpired(true);
        repository.save(entity);
    }

    @Override
    public List<DiscountCard> filter(boolean expired) {
        return repository.filter(expired);
    }
}
