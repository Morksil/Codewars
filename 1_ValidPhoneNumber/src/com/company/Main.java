package com.company;
/*
* Write a function that accepts a string, and returns true if it is in the form of a phone number.
Assume that any integer from 0-9 in any of the spots will produce a valid phone number.

Only worry about the following format:
(123) 456-7890 (don't forget the space after the close parentheses)
*/
public class Main {

    public static void main(String[] args) {
        System.out.println(validPhoneNumber("(123) 123-1234"));
    }
    public static boolean validPhoneNumber(String phoneNumber) {
        // TODO: Return whether phoneNumber is in the proper form
        if(phoneNumber.charAt(0) == '('
                && phoneNumber.charAt(4)    == ')'
                && phoneNumber.charAt(5)    == ' '
                && phoneNumber.charAt(9)    == '-'
                && phoneNumber.length()     == 14){
            if(isDigit(phoneNumber.charAt(1))
                && isDigit(phoneNumber.charAt(2))
                && isDigit(phoneNumber.charAt(3))
                && isDigit(phoneNumber.charAt(6))
                && isDigit(phoneNumber.charAt(7))
                && isDigit(phoneNumber.charAt(8))
                    && isDigit(phoneNumber.charAt(10))
                    && isDigit(phoneNumber.charAt(11))
                    && isDigit(phoneNumber.charAt(12))
                    && isDigit(phoneNumber.charAt(13))){
                return true;
            }
        }
            return false;
    }
    public static boolean isDigit(char character){
        String digits = "0123456789";
        if(digits.indexOf(character)!=-1){
            return true;
        }else{
            return false;
        }
    }
}
