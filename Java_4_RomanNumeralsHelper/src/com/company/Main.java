package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(toRoman(1234));
        System.out.println(fromRoman("MCCXXXIV"));
    }

    public static String toRoman(int n) {
        String number = String.valueOf(n);
        int numberToCalculations = n;
        int numberOfDigits = number.length();
        List<String> listOfFactors = new ArrayList<>();
        for (int i = 1; i <= numberOfDigits; i++) {
            listOfFactors.add(String.valueOf((int) (numberToCalculations % Math.pow(10, i))));
            numberToCalculations = numberToCalculations - Integer.parseInt(listOfFactors.get(i - 1));
        }
        String romanNumeral = "";
        for (int i = 0; i < listOfFactors.size(); i++) {
            if (i == 0) {
                switch (listOfFactors.get(i)) {
                    case "1": romanNumeral = "I"    + romanNumeral;break;
                    case "2": romanNumeral = "II"   + romanNumeral;break;
                    case "3": romanNumeral = "III"  + romanNumeral;break;
                    case "4": romanNumeral = "IV"   + romanNumeral;break;
                    case "5": romanNumeral = "V"    + romanNumeral;break;
                    case "6": romanNumeral = "VI"   + romanNumeral;break;
                    case "7": romanNumeral = "VII"  + romanNumeral;break;
                    case "8": romanNumeral = "VIII" + romanNumeral;break;
                    case "9": romanNumeral = "IX"   + romanNumeral;break;
                }
            } else if (i == 1) {
                switch (listOfFactors.get(i)) {
                    case "10": romanNumeral = "X"   + romanNumeral;break;
                    case "20": romanNumeral = "XX"  + romanNumeral;break;
                    case "30": romanNumeral = "XXX" + romanNumeral;break;
                    case "40": romanNumeral = "XL"  + romanNumeral;break;
                    case "50": romanNumeral = "L"   + romanNumeral;break;
                    case "60": romanNumeral = "LX"  + romanNumeral;break;
                    case "70": romanNumeral = "LXX" + romanNumeral;break;
                    case "80": romanNumeral = "LXXX"+ romanNumeral;break;
                    case "90": romanNumeral = "XC"  + romanNumeral;break;
                }
            } else if (i == 2) {
                switch (listOfFactors.get(i)) {
                    case "100": romanNumeral = "C"      + romanNumeral;break;
                    case "200": romanNumeral = "CC"     + romanNumeral;break;
                    case "300": romanNumeral = "CCC"    + romanNumeral;break;
                    case "400": romanNumeral = "CD"     + romanNumeral;break;
                    case "500": romanNumeral = "D"      + romanNumeral;break;
                    case "600": romanNumeral = "DC"     + romanNumeral;break;
                    case "700": romanNumeral = "DCC"    + romanNumeral;break;
                    case "800": romanNumeral = "DCCC"   + romanNumeral;break;
                    case "900": romanNumeral = "CM"     + romanNumeral;break;
                }
            } else if (i == 3) {
                switch (listOfFactors.get(i)) {
                    case "1000": romanNumeral = "M"     + romanNumeral;break;
                    case "2000": romanNumeral = "MM"    + romanNumeral;break;
                    case "3000": romanNumeral = "MMM"   + romanNumeral;break;
                }
            }
        }
        return romanNumeral;
    }

    public static int fromRoman(String romanNumeral) {
        int number = 0;
            if(romanNumeral.contains("IX")){
                number += 9;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("VIII")){
                number += 8;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-4);
            } else if(romanNumeral.contains("VII")){
                number += 7;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("VI")){
                number += 6;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("IV")){
                number += 4;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("V")){
                number += 5;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            } else if(romanNumeral.contains("III")){
                number += 3;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("II")){
                number += 2;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("I")){
                number += 1;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            }
            if(romanNumeral.contains("XC")){
                number += 90;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("LXXX")){
                number+=80;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-4);
            } else if(romanNumeral.contains("LXX")){
                number+=70;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("LX")){
                number+=60;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("XL")){
                number+=40;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("L")){
                number+=50;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            } else if(romanNumeral.contains("XXX")){
                number+=30;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("XX")){
                number+=20;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            }else if(romanNumeral.contains("X")){
                number+=10;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            }
            if(romanNumeral.contains("CM")){
                number += 900;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("DCCC")){
                number+= 800;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-4);
            } else if(romanNumeral.contains("DCC")){
                number+= 700;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("DC")){
                number+= 600;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("CD")){
                number+= 400;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("D")){
                number+= 500;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            } else if(romanNumeral.contains("CCC")){
                number+= 300;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-3);
            } else if(romanNumeral.contains("CC")){
                number+= 200;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-2);
            } else if(romanNumeral.contains("C")){
                number+= 100;
                romanNumeral = romanNumeral.substring(0,romanNumeral.length()-1);
            }
            if(romanNumeral.contains("MMM")){
                number+=3000;
            } else if(romanNumeral.contains("MM")){
                number+=2000;
            } else if(romanNumeral.contains("M")){
                number+=1000;
            }
        return number;
    }
}
