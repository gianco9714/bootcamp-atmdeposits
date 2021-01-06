package com.gian.deposits.model.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FingerprintRequestTest {

    FingerprintRequest mock;

    @Test
    public void testGetAndSet(){
        mock = new FingerprintRequest();

        mock.setDocument("10000000");

        assertTrue("10000000".equals(mock.getDocument()));
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            FingerprintRequest fingerprintRequest = new FingerprintRequest("10000000");
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}
