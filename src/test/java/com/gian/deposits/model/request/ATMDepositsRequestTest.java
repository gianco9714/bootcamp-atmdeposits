package com.gian.deposits.model.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ATMDepositsRequestTest {

    ATMDepositsRequest mock;

    @Test
    public void testGetAndSet(){
        mock = new ATMDepositsRequest();

        mock.setDocumentNumber("10000000");

        assertTrue("10000000".equals(mock.getDocumentNumber()));
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            ATMDepositsRequest atmDepositsRequest = new ATMDepositsRequest("10000000");
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}

