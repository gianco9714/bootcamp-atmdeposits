package com.gian.deposits.service;

import com.gian.deposits.model.request.ATMDepositsRequest;
import com.gian.deposits.model.response.ATMDepositsResponse;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.RequestBody;

public interface IDepositsService {

    Single<ATMDepositsResponse> validateUser(ATMDepositsRequest atmDepositsRequest);
}
