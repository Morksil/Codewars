package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(ileLat(50,20));
    }
    public static int ileLat(int wiekOjca, int wiekSyna){
        return (Math.abs(wiekOjca - wiekSyna * 2));
    }

}
