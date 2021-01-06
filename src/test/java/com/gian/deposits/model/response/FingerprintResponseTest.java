package com.gian.deposits.model.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FingerprintResponseTest {

    FingerprintResponse mock;

    @Test
    public void testGetAndSet(){
        mock = new FingerprintResponse();

        mock.setEntityName("Core");
        mock.setSuccess(true);

        assertTrue("Core".equals(mock.getEntityName()));
        assertTrue(mock.isSuccess() == true);
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            FingerprintResponse fingerprintResponse = new FingerprintResponse("Core",true);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}
