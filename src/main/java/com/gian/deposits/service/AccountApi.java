package com.gian.deposits.service;

import com.gian.deposits.model.response.AccountResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccountApi {
    @GET("/core/accounts")
    Single<AccountResponse> getAccount(@Query("cardNumber") String cardNumber);
}
