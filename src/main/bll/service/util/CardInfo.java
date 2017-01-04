package main.bll.service.util;

import main.bll.modeldto.CardDTO;


import java.util.Date;
import java.util.Random;

public class CardInfo {

    public static final double CURSE_EUR=70;
    public static final double CURSE_RUB=1;
    public static final double CURSE_USD=60;

    public CardInfo() {
    }

    public int generateNumberCard(){
        Random rnd = new Random(System.currentTimeMillis());
        int min = 100000000;
        int max = 900000000;

        return min+rnd.nextInt(max-min+1);
    }

    public Date setValidOfCard(int longer){
        //добавить логику увеличения даты на longer (лет) относительно текущей
        return new Date(longer);
    }

    public double getBalance(double balance, CardCurrency cardCurrency){
        double total;

        switch (cardCurrency){
            case EUR: {
                total =balance/CURSE_EUR;
                break;
            }
            case RUB: {
                total =balance;
                break;
            }
            case USD: {
                total =balance/CURSE_USD;
                break;
            }
            default: {
                total=-1;
                break;
            }
        }
        return total;
    }


}
