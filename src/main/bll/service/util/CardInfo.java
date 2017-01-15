package main.bll.service.util;

import main.bll.service.myexeption.InterneteBankExeption;
import main.dal.api.IUnitOfWork;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class CardInfo {

    public static final double CURSE_EUR = 70;
    public static final double CURSE_RUB = 1;
    public static final double CURSE_USD = 60;

    public enum CardCurrency {
        EUR, USD, RUB;
    }

    public int generateNumberCard() {
        Random rnd = new Random(System.currentTimeMillis());
        int min = 100000000;
        int max = 900000000;

        return min + rnd.nextInt(max - min + 1);
    }

    public Date setValidOfCard(int longer) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, longer);
        Date date = calendar.getTime();
        return date;
    }

    public boolean checkUniqNumberCard(IUnitOfWork unit, int newNumberCard) throws InterneteBankExeption {
        boolean check = false;
        try {
            check = unit.cards().getAll().stream().anyMatch(x -> x.getNumber() == newNumberCard);
        } catch (SQLException e) {
            throw new InterneteBankExeption("Ошибка получения данных");
        }
        return check;
    }

    public double getBalance(double balance, CardCurrency cardCurrency) {
        double total;

        switch (cardCurrency) {
            case EUR: {
                total = balance / CURSE_EUR;
                break;
            }
            case RUB: {
                total = balance;
                break;
            }
            case USD: {
                total = balance / CURSE_USD;
                break;
            }
            default: {
                total = balance;
                break;
            }
        }
        return total;
    }


}
