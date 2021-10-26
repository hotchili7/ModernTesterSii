package kolekcje;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DuzeLiczby {
    public static void main(String[] args) {
        BigDecimal price1 = new BigDecimal("1.55");
        BigDecimal price2 = new BigDecimal("2.5885");
        BigDecimal price3 = new BigDecimal("4.348");
        BigDecimal price4 = new BigDecimal("125.56");
        BigDecimal price5 = new BigDecimal("4.99");
        BigDecimal price6= new BigDecimal("47.333");

        List<BigDecimal> prices = new ArrayList<>();

        prices.add(price1);
        prices.add(price2);
        prices.add(price3);
        prices.add(price4);
        prices.add(price5);
        prices.add(price6);

        System.out.println(prices);

//        for (BigDecimal price : prices) {
//            if (price.compareTo(new BigDecimal("5")) < 0 ){
//                price = price.add(new BigDecimal("2"));
//            }
//            System.out.println(price);
//        }


//        pomnożyć
       BigDecimal result =  price1.multiply(price5);

        System.out.println(result);

//         podzielić p6/p2 + zaokrąglenie

        BigDecimal divider = price6.divide(price2, 2, RoundingMode.DOWN);
        System.out.println(divider);

//        odejmowanie p1-p6

        BigDecimal subtract = price1.subtract(price6);
        System.out.println(subtract);


//        jeśli ceny < 10 => pomnożyć 8

        System.out.println("Pomnożone 8*: ");

        for (BigDecimal price : prices) {
            if (price.compareTo(new BigDecimal("10")) < 0) {
                System.out.println(price.multiply(new BigDecimal("8")));
            }
        }


        int a = 1000000000;
        int b = 1000000;

        System.out.println(a*b);

        BigDecimal a1 = new BigDecimal("100000000000");
        BigDecimal a2 = new BigDecimal("1000000000");

        System.out.println(a1.multiply(a2));




    }

}
