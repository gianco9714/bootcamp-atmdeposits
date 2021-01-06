package com.gian.deposits.service;

import com.gian.deposits.model.request.ReniecRequest;
import com.gian.deposits.model.response.ReniecResponse;
import io.reactivex.Single;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReniecApi {

    @POST("/external/reniec/validate")
    Single<ReniecResponse> validateReniec(@Body ReniecRequest reniecRequest);
}
