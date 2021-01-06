package com.gian.deposits.service;

import com.gian.deposits.controller.DepositsController;
import com.gian.deposits.model.entity.ValidateAccounts;
import com.gian.deposits.model.request.ATMDepositsRequest;
import com.gian.deposits.model.response.ATMDepositsResponse;
import com.gian.deposits.model.response.AccountResponse;
import com.gian.deposits.service.impl.DepositServiceImpl;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepositServiceTest {

    @InjectMocks
    private DepositsController controller;

    @Mock
    private AccountApi accountApi;

    @Test
    public void validateUser(){

//      Mock
        Single<AccountResponse> accountResponseSingle = Single.just(new AccountResponse("1111222233334441" + "XXX", 1000));
        when(accountApi.getAccount(anyString())).thenReturn(accountResponseSingle);

//      Test
        controller.getAccount("1111222233334441");

        assertTrue(controller.getAccount("1111222233334441").equals(accountResponseSingle));

    }
}
