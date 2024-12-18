package org.telran.shop.de.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telran.shop.de.entity.DiscountCard;
import org.telran.shop.de.exception.CardNotFoundException;
import org.telran.shop.de.repository.DiscountCardJpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class DiscountCardServiceImplTest {

    @Mock
    private DiscountCardJpaRepository discountCardJpaRepository;

    @InjectMocks
    private DiscountCardServiceImpl discountCardService;

    @Test
    public void getDiscountCardByIdWhenCardExists() {
        String discountCardId = "3333333";
        DiscountCard discountCardExpected= new DiscountCard();
        discountCardExpected.setId("3333333");

        when(discountCardJpaRepository.findById(discountCardId))
                .thenReturn((Optional.of(discountCardExpected)));

        DiscountCard cardActual = discountCardService.getById(discountCardId);
        assertEquals(discountCardExpected.getId(), cardActual.getId());
    }

    @Test
    public void getDiscountCardByIdWhenCardNotExists() {
        String discountCardId = "4444444";
        when(discountCardJpaRepository.findById(discountCardId))
                .thenThrow(new CardNotFoundException("Card not found"));
        assertThrows(CardNotFoundException.class,
                () -> discountCardService.getById(discountCardId));
    }
}