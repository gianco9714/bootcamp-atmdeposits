package com.gian.deposits.service.impl;

import com.gian.deposits.model.entity.ValidateAccounts;
import com.gian.deposits.model.request.ATMDepositsRequest;
import com.gian.deposits.model.request.FingerprintRequest;
import com.gian.deposits.model.request.ReniecRequest;
import com.gian.deposits.model.response.ATMDepositsResponse;
import com.gian.deposits.model.response.AccountResponse;
import com.gian.deposits.model.response.PersonResponse;
import com.gian.deposits.service.*;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositServiceImpl implements IDepositsService {

    @Autowired
    private PersonApi personApi;

    @Autowired
    private ReniecApi reniecApi;

    @Autowired
    private FingerprintApi fingerprintApi;

    @Autowired
    private CardApi cardApi;

    @Autowired
    private AccountApi accountApi;

    @Override
    public Single<ATMDepositsResponse> validateUser(ATMDepositsRequest atmDepositsRequest) {
        Single<PersonResponse> personResponseSingle = personApi.getPersonInfo(atmDepositsRequest.getDocumentNumber());
        PersonResponse p = personResponseSingle.toObservable().blockingFirst();

        String entityName ="";

        if (p.isFingerprint()){
            entityName = fingerprintApi.validateFingerPrint(new FingerprintRequest(atmDepositsRequest.getDocumentNumber())).toObservable().blockingFirst().getEntityName();
        } else {
            entityName = reniecApi.validateReniec(new ReniecRequest(atmDepositsRequest.getDocumentNumber())).toObservable().blockingFirst().getEntityName();
        }

        List<ValidateAccounts> validateAccountsList1 = new ArrayList<>();
        List<Integer> customerAmount = new ArrayList<>();

        cardApi.getCards(atmDepositsRequest.getDocumentNumber())
                .toObservable()
                .blockingFirst()
                .getCards()
                .stream()
                .filter(x->x.isActive())
                .forEach(y->{
                    AccountResponse accountResponse = accountApi.getAccount(y.getCardNumber()).toObservable().blockingFirst();
                    validateAccountsList1.add(new ValidateAccounts(accountResponse.getAccountNumber()));
                    customerAmount.add(accountResponse.getAmount());
                });

        Integer sum = customerAmount.stream().reduce(0, (a, b) -> a + b);

        ATMDepositsResponse response = new ATMDepositsResponse();
        response.setFingerprintEntityName(entityName);
        response.setValidAccounts(validateAccountsList1);
        response.setCustomerAmount(sum);
        return Single.just(response);
    }
}
