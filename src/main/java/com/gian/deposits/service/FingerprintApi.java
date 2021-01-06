package com.gian.deposits.service;

import com.gian.deposits.model.request.FingerprintRequest;
import com.gian.deposits.model.response.FingerprintResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface FingerprintApi {

    @POST("/core/fingerprints/validate")
    Single<FingerprintResponse> validateFingerPrint(@Body FingerprintRequest fingerprintRequest);
}
