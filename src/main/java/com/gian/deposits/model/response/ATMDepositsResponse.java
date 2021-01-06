package com.gian.deposits.model.response;

import com.gian.deposits.model.entity.ValidateAccounts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ATMDepositsResponse {
    private String fingerprintEntityName;
    private List<ValidateAccounts> validAccounts;
    private Integer customerAmount;

}
