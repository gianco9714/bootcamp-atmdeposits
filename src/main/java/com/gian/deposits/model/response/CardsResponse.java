package com.gian.deposits.model.response;

import com.gian.deposits.model.entity.CardsInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardsResponse {
    List<CardsInfo> cards;
}
