package com.alasgarov;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        long cardNumber = 4098584467212395L;
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            arrayList.add(cardNumber % 10);
            cardNumber /= 10;
        }
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        for (int i = 1; i <= arrayList.size(); i++) {
            if (i%2 == 1){
                arrayList.set(i-1, arrayList.get(i - 1) * 2);
            }
        }

        System.out.println(arrayList);

        for (int i = 1; i <= arrayList.size(); i++) {
            if (arrayList.get(i-1) > 9){
                arrayList.set(i-1, aMethod(arrayList.get(i - 1)));
            }
        }
        System.out.println(arrayList);

        long sum = 0;
        for (Long e: arrayList){
            sum+=e;
        }

        System.out.println("sum = " + sum);

        if(sum%10==0){
            System.out.println("is valid");
        } else
            System.out.println("is not valid");

    }

    static Long aMethod(Long number){
        long a = number % 10;
        long b = number/ 10;
        return a + b;
    }

//    void validCreditCardIdentificationNumber(int cardNumber){
//    }


}