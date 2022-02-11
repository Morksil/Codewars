package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //[twenty-six, thousand, three, hundred, fifty-nine]
        System.out.println(parseInt("two hundred three thousand"));
    }
    public static int parseInt(String numStr) {
        List<String> stringList = Stream.of(numStr.split(" ")).collect(Collectors.toList());
        stringList.remove("and");
        System.out.println(stringList);
        numStr = "";
        for(int i=0;i<stringList.size();i++){
            if(i==0){
                numStr = numStr+stringList.get(i);
            }else{
                numStr = numStr + " " + stringList.get(i);
            }
        }
        int number = 0;
        //Million
        if(numStr.toLowerCase().contains("one million")){
            number += 1000000;
            try{
                numStr = numStr.substring("one million".length() + 1);
            }catch(Exception e){
                numStr = numStr.substring("one million".length());
            }
        }
        //Thousands
        for(int i=0; i< hundreds.length;i++){
            if (numStr.contains(hundreds[i] + " thousand")){
                try{
                    numStr = numStr.substring(hundreds[i].length() + " thousand".length() + 1);
                }catch(Exception e){
                    numStr = numStr.substring(hundreds[i].length() + " thousand".length());
                }
                number += (i + 1) * 100000;
            }
            for(int j=0; j< fromTenToNinety.length;j++){
                if(numStr.contains(hundreds[i] + " " +fromTenToNinety[j] + " thousand")){
                    try{
                        numStr = numStr.substring(hundreds[i].length() + " ".length() + fromTenToNinety[j].length() +
                                " thousand".length() + 1);
                    }catch(Exception e){
                        numStr = numStr.substring(hundreds[i].length() + " ".length() + fromTenToNinety[j].length() +
                                " thousand".length());
                    }

                    if(j < 10){number += (j+10) * 1000 + (i+1) * 100000;}
                    else{number += (j-8) * 10000 + (i+1) * 100000;}
                }
                for(int k=0; k< fromZeroToNine.length;k++){
                    if(numStr.contains(hundreds[i] + " " + fromTenToNinety[j] + "-" + fromZeroToNine[k] + " thousand")){
                        numStr = numStr.substring(hundreds[i].length() + " ".length() + fromTenToNinety[j].length() +
                                "-".length() + fromZeroToNine[k].length() + " thousand".length());
                        number += (j-8) * 10000 + k * 1000 + (i+1) * 100000;
                    }
                }
            }
            for(int k=0; k< fromZeroToNine.length;k++){
                if(numStr.contains(hundreds[i] + " " + fromZeroToNine[k] + " thousand")){
                    numStr = numStr.substring(hundreds[i].length() +
                            " ".length() + fromZeroToNine[k].length() + " thousand".length());
                    number += k * 1000 + (i+1) * 100000;
                }
            }
        }
        for(int i=0;i < fromTenToNinety.length;i++){
            for(int j=0; j< fromZeroToNine.length;j++){
                if(numStr.contains(fromTenToNinety[i] + "-" + fromZeroToNine[j] + " thousand")){
                    try{
                        numStr = numStr.substring(fromTenToNinety[i].length() + "-".length() + fromZeroToNine[j].length()
                                + " thousand".length() + 1);
                    }catch(Exception e){
                        numStr = numStr.substring(fromTenToNinety[i].length() + "-".length() + fromZeroToNine[j].length()
                                + " thousand".length());
                    }
                    number += (i-8) * 10000 + j * 1000;
                }
            }
        }
        System.out.println(numStr);
        for(int i=0; i < fromTenToNinety.length;i++){
            if(numStr.contains(fromTenToNinety[i] + " thousand")){
                try{
                    numStr = numStr.substring(fromTenToNinety[i].length() + " thousand".length() + 1);
                }catch(Exception e){
                    numStr = numStr.substring(fromTenToNinety[i].length() + " thousand".length());
                }
                if(i < 10){number += (i+10) * 1000;}
                else{number += (i-8) * 10000;}
            }
        }
        for(int i=0; i < fromZeroToNine.length; i++){
            if(numStr.contains(fromZeroToNine[i] + " thousand")){
                try{
                    numStr = numStr.substring(fromZeroToNine[i].length() + " thousand".length() + 1);
                }catch(Exception e){
                    numStr = numStr.substring(fromZeroToNine[i].length() + " thousand".length());
                }
                number += i * 1000;
            }
        }
        //Hundreds
        for(int i=0; i< hundreds.length; i++){
            if(numStr.contains(hundreds[i])){
                try{
                    numStr = numStr.substring(hundreds[i].length() + 1);
                }catch(Exception e){
                    numStr = numStr.substring(hundreds[i].length());
                }
                number += (i+1) * 100;
            }
        }
        //Dozens
        for(int i=0;i < fromTenToNinety.length;i++){
            for(int j=0; j< fromZeroToNine.length;j++){
                if(numStr.contains(fromTenToNinety[i] + "-" + fromZeroToNine[j])){
                    numStr = "";
                    number += (i-8) * 10 + j;
                }
            }
        }
        for(int i=0; i < fromTenToNinety.length;i++){
            if(numStr.contains(fromTenToNinety[i])){
                numStr = "";
                if(i < 10){number += (i+10);}
                else{number += (i-8) * 10;}
            }
        }
        //Units
        for(int i=0; i<fromZeroToNine.length;i++){
            if(numStr.contains(fromZeroToNine[i])){
                numStr = "";
                number += i;
            }
        }
        return number;
    }
}
