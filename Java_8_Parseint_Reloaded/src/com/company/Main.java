package com.company;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
//Solutions----------------------------------------------------------------------------------------------------Solutions
/*import java.util.HashMap;
import java.util.Map;

    public class Parser {

        public static int parseInt(String numStr) {
            String[] numArray = numStr.split("[ |-]");
            int number = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("zero", 0);
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            map.put("four", 4);
            map.put("five", 5);
            map.put("six", 6);
            map.put("seven", 7);
            map.put("eight", 8);
            map.put("nine", 9);
            map.put("ten", 10);
            map.put("eleven", 11);
            map.put("twelve", 12);
            map.put("thirteen", 13);
            map.put("fourteen", 14);
            map.put("fifteen", 15);
            map.put("sixteen", 16);
            map.put("seventeen", 17);
            map.put("eighteen", 18);
            map.put("nineteen", 19);
            map.put("twenty", 20);
            map.put("thirty", 30);
            map.put("forty", 40);
            map.put("fifty", 50);
            map.put("sixty", 60);
            map.put("seventy", 70);
            map.put("eighty", 80);
            map.put("ninety", 90);
            map.put("hundred", 100);
            map.put("thousand", 1000);
            map.put("million", 1000000);

            for (int i = 0; i < numArray.length; i++) {
                for (String key : map.keySet()) {
                    if (numArray[i].toLowerCase().equals(key)) {
                        if (map.get(key) == 100) {
                            int temp = number % 100;
                            number -= temp;
                            number += temp * (map.get(key));
                        }
                        else if (map.get(key) > 100)
                            number *= (map.get(key));
                        else
                            number += map.get(key);
                        break;
                    }
                }
            }
            return number;
        }
    }*/
/*import java.util.*;
import java.util.stream.*;

    public class Parser {

        final static private String[] SPLITTER = Arrays.asList("million", "thousand", "hundred", "ty\\b")
                .stream()
                .map( r -> String.format("\\s*%s\\s*", r) )
                .toArray(String[]::new);

        final static private int[]    COEFS = {1000000, 1000, 100, 10};
        final static private String[] vals  = "zero one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen".split(" ");
        final static private Map<String,Integer> VALUES = defineStaticValues();


        private static Map<String,Integer> defineStaticValues() {
            Map<String,Integer> map = IntStream.range(0,vals.length)
                    .boxed()
                    .collect(Collectors.toMap( i-> vals[i], i -> i));
            map.put("twen", 2);    map.put("thir", 3);
            map.put("for",  4);    map.put("fif",  5);
            map.put("eigh", 8);
            return map;
        }


        public static int parseInt(String s) { return parse(0, s.replaceAll("(\\s|-|\\band)+", " ")); }

        private static int parse(int i, String s) {
            if (i == SPLITTER.length) return VALUES.getOrDefault(s, 0);

            String[] arr = s.split(SPLITTER[i], -1);

            return arr.length==1 ? parse(i+1, arr[0])
                    : COEFS[i] * parse(i+1,arr[0]) + parse(i+1,arr[1]);
        }

    }*/
}
