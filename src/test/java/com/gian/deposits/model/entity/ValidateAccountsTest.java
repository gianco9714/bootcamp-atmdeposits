package com.gian.deposits.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateAccountsTest {

    ValidateAccounts mock;

    @Test
    public void testGetAndSet(){
        mock = new ValidateAccounts();

        mock.setAccountNumber("1111222233334441XXX");

        assertTrue("1111222233334441XXX".equals(mock.getAccountNumber()));

    }
}
