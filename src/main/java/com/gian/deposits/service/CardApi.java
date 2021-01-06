package com.gian.deposits.service;

import com.gian.deposits.model.response.CardsResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CardApi {

    @GET("core/cards")
    Single<CardsResponse> getCards(@Query("documentNumber") String documentNumber);
}
