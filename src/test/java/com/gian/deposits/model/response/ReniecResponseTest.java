package com.gian.deposits.model.response;

import com.gian.deposits.model.request.ReniecRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReniecResponseTest {

    ReniecResponse mock;

    @Test
    public void testGetAndSet(){
        mock = new ReniecResponse();

        mock.setEntityName("Reniec");
        mock.setSuccess(true);

        assertTrue("Reniec".equals(mock.getEntityName()));
        assertTrue(true == mock.isSuccess() );
    }

    @Test
    public void testAllARgsException(){
        boolean flag;
        try {
            ReniecResponse reniecResponse = new ReniecResponse("Core",true);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }
}
