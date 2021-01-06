package com.gian.deposits.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardsInfoTest {

    CardsInfo mock;

    @Test
    public void testGetAndSet(){
        mock = new CardsInfo();

        mock.setCardNumber("1111222233334441");
        mock.setActive(true);

        assertTrue("1111222233334441".equals(mock.getCardNumber()));
        assertTrue(mock.isActive());
    }
}
