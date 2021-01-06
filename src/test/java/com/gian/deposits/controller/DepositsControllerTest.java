package com.gian.deposits.controller;

import com.gian.deposits.model.entity.CardsInfo;
import com.gian.deposits.model.entity.ValidateAccounts;
import com.gian.deposits.model.request.ATMDepositsRequest;
import com.gian.deposits.model.request.FingerprintRequest;
import com.gian.deposits.model.request.ReniecRequest;
import com.gian.deposits.model.response.*;

import com.gian.deposits.service.*;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepositsControllerTest {

    @InjectMocks
    private DepositsController controller;

    @Mock
    private AccountApi accountApi;

    @Mock
    private FingerprintApi fingerprintApi;

    @Mock
    private ReniecApi reniecApi;

    @Mock
    private CardApi cardApi;

    @Mock
    private PersonApi personApi;

    @Mock
    private IDepositsService depositsService;

    @Test
    public void getAccountsTest(){

//      Mock
        Single<AccountResponse> accountResponseSingle = Single.just(new AccountResponse("1111222233334441" + "XXX", 1000));
        when(accountApi.getAccount(anyString())).thenReturn(accountResponseSingle);

//      Test
        controller.getAccount("1111222233334441");

        assertTrue(controller.getAccount("1111222233334441").equals(accountResponseSingle));

    }

    @Test
    public void validateFingerPrintTest(){
        FingerprintRequest fingerprintRequest = new FingerprintRequest("10000000");

        Single<FingerprintResponse> fingerprintResponseSingle = Single.just(new FingerprintResponse("Core",true));
        when(fingerprintApi.validateFingerPrint(fingerprintRequest)).thenReturn(fingerprintResponseSingle);

        controller.validateFingerPrint(fingerprintRequest);

        assertTrue(controller.validateFingerPrint(fingerprintRequest).equals(fingerprintResponseSingle));
    }

    @Test
    public void validateReniecTest(){
        ReniecRequest reniecRequest = new ReniecRequest("10000000");

        Single<ReniecResponse> reniecResponseSingle = Single.just(new ReniecResponse("Reniec",true));
        when(reniecApi.validateReniec(reniecRequest)).thenReturn(reniecResponseSingle);

        controller.validateReniec(reniecRequest);

        assertTrue(controller.validateReniec(reniecRequest).equals(reniecResponseSingle));
    }

    @Test
    public void getCardTest(){

        List<CardsInfo> cardsInfoList = Arrays.asList(
                new CardsInfo("1111222233334441", true)
        );

        Single<CardsResponse> cardsResponseSingle = Single.just(new CardsResponse(cardsInfoList));
        when(cardApi.getCards(anyString())).thenReturn(cardsResponseSingle);

        controller.getCards("10000000");

        assertTrue(controller.getCards("10000000").equals(cardsResponseSingle));

    }

    @Test
    public void getPersonsTest(){

        Single<PersonResponse> personResponseSingle = Single.just(new PersonResponse("1","10000000",true,true));
        when(personApi.getPersonInfo(anyString())).thenReturn(personResponseSingle);

        controller.getPerson("10000000");

        assertTrue(controller.getPerson("10000000").equals(personResponseSingle));

    }

    @Test
    public void validateUserTest(){

        ATMDepositsRequest atmDepositsRequest = new ATMDepositsRequest("10000000");

        List<ValidateAccounts> validateAccountsList = Arrays.asList(
                new ValidateAccounts("1111222233334441XXX")
        );

        Single<ATMDepositsResponse> atmDepositsResponseSingle = Single.just(new ATMDepositsResponse("Core",validateAccountsList,1000));
        when(depositsService.validateUser(atmDepositsRequest)).thenReturn(atmDepositsResponseSingle);

        controller.validateUser(atmDepositsRequest);

        assertTrue(controller.validateUser(atmDepositsRequest).equals(atmDepositsResponseSingle));

    }



}
