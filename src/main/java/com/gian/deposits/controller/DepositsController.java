package com.gian.deposits.controller;

import com.gian.deposits.model.entity.ValidateAccounts;
import com.gian.deposits.model.request.ATMDepositsRequest;
import com.gian.deposits.model.request.FingerprintRequest;
import com.gian.deposits.model.request.ReniecRequest;
import com.gian.deposits.model.response.*;
import com.gian.deposits.service.*;
import io.reactivex.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Slf4j
@Validated
@RestController
@Api(value = "DepositsController", produces = "application/json", tags = { "Deposit Controller" })
public class DepositsController {

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

    @Autowired
    private IDepositsService depositsService;

    @ApiOperation(value = "Obtener Personas", tags = { "Deposit Controller" })
    @GetMapping(value = "/persons", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = PersonResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<PersonResponse> getPerson(@RequestParam String documentNumber){

        return personApi.getPersonInfo(documentNumber);
    }

    @ApiOperation(value = "Validar Reniec", tags = { "Deposit Controller" })
    @PostMapping(value = "/reniec/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = ReniecResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<ReniecResponse> validateReniec(@RequestBody ReniecRequest reniecRequest){

        return reniecApi.validateReniec(reniecRequest);
    }

    @ApiOperation(value = "Validar Fingerprint", tags = { "Deposit Controller" })
    @PostMapping(value = "/fingerprints/validate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = FingerprintResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<FingerprintResponse> validateFingerPrint(@RequestBody FingerprintRequest fingerprintRequest){

        return fingerprintApi.validateFingerPrint(fingerprintRequest);
    }

    @ApiOperation(value = "Obtener Tarjetas", tags = { "Deposit Controller" })
    @GetMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = CardsResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<CardsResponse> getCards(@RequestParam String documentNumber){

        return cardApi.getCards(documentNumber);
    }

    @ApiOperation(value = "Obtener Cuentas", tags = { "Deposit Controller" })
    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = AccountResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<AccountResponse> getAccount(@RequestParam String cardNumber){

        return accountApi.getAccount(cardNumber);
    }

    @ApiOperation(value = "Valida el usuario", tags = { "Deposit Controller" })
    @PostMapping(value = "/atm/deposits", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = ATMDepositsResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<ATMDepositsResponse> validateUser(@RequestBody ATMDepositsRequest atmDepositsRequest){

        return depositsService.validateUser(atmDepositsRequest);
    }

}
