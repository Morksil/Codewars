package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productFib(4895L)));
    }
    public static long[] productFib(long prod) {
        List<Long> listFibonacci = new ArrayList<>();
        listFibonacci.add(0L);
        listFibonacci.add(1L);
        boolean isOK = false;
        int i = 2;
        while(true){
            if(listFibonacci.get(i-1)*listFibonacci.get(i-2) > prod){
                isOK = false;
                return new long[] {listFibonacci.get(i-2), listFibonacci.get(i-1), 0};
            }else if(listFibonacci.get(i-1)*listFibonacci.get(i-2) == prod){
                isOK = true;
                return new long[] {listFibonacci.get(i-2), listFibonacci.get(i-1), 1};
            }
            listFibonacci.add(listFibonacci.get(i-2) + listFibonacci.get(i-1));
            i++;
        }
    }
}

