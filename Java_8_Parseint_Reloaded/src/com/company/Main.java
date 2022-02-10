package com.company;

import java.util.Locale;
import java.util.regex.Pattern;

public class Main {
    public static String fromZeroToNine[] =         {"zero","one","two","three","four","five","six","seven","eight",
                                                     "nine"};
    public static String fromTenToNinety[] =        {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
                                                     "seventeen", "eighteen","nineteen", "twenty", "thirty","forty",
                                                     "fifty","sixty","seventy", "eighty","ninety"};
    public static String hundreds[] =               {"one hundred","two hundred","three hundred","four hundred",
                                                     "five hundred","six hundred", "seven hundred","eight hundred",
                                                     "nine hundred"};

    public static void main(String[] args) {
        System.out.println(parseInt("OnE million one hundred thousand three hundred five"));
    }
    public static int parseInt(String numStr) {
        int number = 0;
        //Milion jest ok
        if(numStr.toLowerCase().contains("one million")){
            number += 1000000;
            numStr = numStr.substring("one million".length() + 1);
        }
        //Tysiace
        for(int i=0; i< hundreds.length;i++){
            if (numStr.contains(hundreds[i] + " thousand")){
                numStr = numStr.substring(hundreds[i].length() + " thousand".length() + 1);
                number += (i + 1) + 100000;
            }
            for(int j=0; j< fromTenToNinety.length;j++){

            }
        }
        for(int i=0;i < fromTenToNinety.length;i++){
            for(int j=0; j< fromZeroToNine.length;j++){
                if(numStr.contains(fromTenToNinety[i] + "-" + fromZeroToNine[j] + " thousand")){
                    numStr = numStr.substring(fromTenToNinety[i].length() + "-".length() + fromZeroToNine[j].length()
                            + " thousand".length() + 1);
                    number += (i-8) * 10000 + j * 1000;
                }
            }
        }
        for(int i=0; i < fromTenToNinety.length;i++){
            if(numStr.contains(fromTenToNinety[i] + " thousand")){
                numStr = numStr.substring(fromTenToNinety[i].length() + " thousand".length() + 1);
                if(i < 10){number += (i+10) * 1000;}
                else{number += (i-8) * 10000;}
            }

        }
        for(int i=0; i < fromZeroToNine.length; i++){
            if(numStr.contains(fromZeroToNine[i] + " thousand")){
                numStr = numStr.substring(fromZeroToNine[i].length() + " thousand".length() + 1);
                number += i * 1000;
            }
        }

        //for(int i=0; i<fromZeroToNine.length;i++){
        //    if(numStr.contains(fromZeroToNine[i] + " hundred")){
        //        numStr = numStr.substring(fromZeroToNine[i].length() + " hundred".length() + 1);
        //        number += i * 100;
        //    }
        //}
        for(int i=0; i< hundreds.length; i++){
            if(numStr.contains(hundreds[i])){
                numStr = numStr.substring(hundreds[i].length() +1);
                number += (i+1) * 100;
            }
        }
        for(int i=0; i<fromZeroToNine.length;i++){
            if(numStr.contains(fromZeroToNine[i])){
                numStr = "";
                number += i;
            }
        }
        System.out.println(numStr);
        return number;
    }
}
