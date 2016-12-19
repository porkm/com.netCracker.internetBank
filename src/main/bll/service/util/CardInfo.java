package main.bll.service.util;

import java.util.Date;
import java.util.Random;

public class CardInfo {

    public int generateNumberCard(){

        Random rnd = new Random(System.currentTimeMillis());
        int min = 10000000;
        int max = 90000000;

        return min+rnd.nextInt(max-min+1);
    }

    public java.sql.Date setValidOfCard(int longer){

        //добавить логику увеличения даты на longer (лет) относительно текущей

        return new java.sql.Date(longer);
    }


}
