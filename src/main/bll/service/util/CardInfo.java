package main.bll.service.util;

import main.bll.modeldto.CardDTO;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, longer);

        Date date = calendar.getTime();
        return date;
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
                total=balance;
                break;
            }
        }
        return total;
    }


}
