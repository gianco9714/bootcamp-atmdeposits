package com.gian.deposits.model.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountResponseTest {

    AccountResponse mock;

    @Test
    public void testGetAndSet(){
        mock = new AccountResponse();

        mock.setAccountNumber("1111222233334441XXX");
        mock.setAmount(1000);

        assertTrue("1111222233334441XXX".equals(mock.getAccountNumber()));
        assertTrue(1000 == mock.getAmount());
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            AccountResponse accountResponse = new AccountResponse("1111222233334441XXX",1000);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}
