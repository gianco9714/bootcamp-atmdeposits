package com.gian.deposits.model.response;

import com.gian.deposits.model.entity.CardsInfo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardsResponseTest {

    CardsResponse mock;

    @Test
    public void testGetAndSet(){

        mock = new CardsResponse();

        List<CardsInfo> cardsInfo = Arrays.asList(
                new CardsInfo("1111222233334441", true),
                new CardsInfo("1111222233334442", true),
                new CardsInfo("1111222233334443", true),
                new CardsInfo("1111222233334444", false),
                new CardsInfo("1111222233334445", false),
                new CardsInfo("1111222233334446", false)
        );

        mock.setCards(cardsInfo);

        assertTrue(mock.getCards().equals(cardsInfo));
    }

    @Test
    public void testAllARgsException(){
        List<CardsInfo> cardsInfo = Arrays.asList(
                new CardsInfo("1111222233334441", true),
                new CardsInfo("1111222233334442", true),
                new CardsInfo("1111222233334443", true),
                new CardsInfo("1111222233334444", false),
                new CardsInfo("1111222233334445", false),
                new CardsInfo("1111222233334446", false)
        );
        boolean flag;
        try {
            CardsResponse cardsResponse = new CardsResponse(cardsInfo);
            flag = true;
        }catch(Exception e){
            flag = false;
        }
        assertTrue(flag);
    }

}
