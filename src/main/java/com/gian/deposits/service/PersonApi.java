package com.gian.deposits.service;

import com.gian.deposits.model.response.PersonResponse;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PersonApi {

    @GET("/core/persons")
    Single<PersonResponse> getPersonInfo(@Query("documentNumber") String documentNumber );
}
