package com.company;

/*
The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.
It's easy to see that the sum of the perimeters of these squares is : 4 * (1 + 1 + 2 + 3 + 5 + 8) = 4 * 20 = 80

Could you give the sum of the perimeters of all the squares in a
when there are n + 1 squares disposed in the same manner as in the drawing:
*/

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(perimeter(new BigInteger("5")));
    }
    public static BigInteger perimeter(BigInteger n) {
        BigInteger sumFibonacci = new BigInteger("2");
        List<BigInteger> listFibonacci = new ArrayList<>();
        listFibonacci.add(new BigInteger("1"));
        listFibonacci.add(new BigInteger("1"));
        for(int i = 2;i < n.intValue() + 1;i++){
            listFibonacci.add(listFibonacci.get(i-2).add(listFibonacci.get(i-1)));
            sumFibonacci = sumFibonacci.add(listFibonacci.get(i));
        }
        //System.out.println(Arrays.toString(listFibonacci.toArray()));
        return (new BigInteger("4")).multiply(sumFibonacci);
    }
}
