package com.company;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        boolean b2 = multipleOf3().matcher("000").matches();
        System.out.println(b2);
    }
    public static Pattern multipleOf3() {
        return Pattern.compile("(1(01*0)*1|0)*");
    }
}
