package com.gian.deposits.model.response;

import com.gian.deposits.model.entity.ValidateAccounts;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ATMDepositsResponseTest {

    ATMDepositsResponse mock;

    @Test
    public void testGetAndSet(){
        mock = new ATMDepositsResponse();

        List<ValidateAccounts> validateAccountsList = Arrays.asList(
                new ValidateAccounts("1111222233334441XXX"),
                new ValidateAccounts("1111222233334442XXX"),
                new ValidateAccounts("1111222233334443XXX")
        );

        mock.setFingerprintEntityName("Core");
        mock.setCustomerAmount(3100);
        mock.setValidAccounts(validateAccountsList);

        assertTrue("Core".equals(mock.getFingerprintEntityName()));
        assertTrue(3100 == mock.getCustomerAmount());
        assertTrue(mock.getValidAccounts().equals(validateAccountsList));
    }

    @Test
    public void testAllARgsException(){
        List<ValidateAccounts> validateAccountsList = Arrays.asList(
                new ValidateAccounts("1111222233334441XXX"),
                new ValidateAccounts("1111222233334442XXX"),
                new ValidateAccounts("1111222233334443XXX")
        );
        boolean flag;
        try {
            ATMDepositsResponse atmDepositsResponse = new ATMDepositsResponse("Core",validateAccountsList,3100);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }

}
