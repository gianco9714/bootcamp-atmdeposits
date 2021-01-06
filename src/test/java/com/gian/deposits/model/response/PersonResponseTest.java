package com.gian.deposits.model.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonResponseTest {

    PersonResponse mock;

    @Test
    public void testGetAndSet(){
        mock = new PersonResponse();

        mock.setBlacklist(true);
        mock.setDocument("10000000");
        mock.setFingerprint(true);
        mock.setId("1");

        assertTrue(true == mock.isBlacklist());
        assertTrue("10000000".equals(mock.getDocument()));
        assertTrue(true == mock.isFingerprint());
        assertTrue("1".equals(mock.getId()));
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            PersonResponse personResponse = new PersonResponse("1","10000000",true,true);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}
