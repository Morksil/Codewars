/*
* Write a function called LCS that accepts two sequences and returns the longest subsequence common to the passed in sequences.
*/
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<String> al = new ArrayList<>();
    static List<String> al2 = new ArrayList<>();

    public static void main(String[] args) {
        lcs("132535365","123456789");
    }
    public static String lcs2(String x, String y) {
        if (x.length() == 0) {
            al.add(y);
            return null;
        }
        lcs2(x.substring(1), y + x.charAt(0));
        lcs2(x.substring(1), y);
        return null;
    }
    public static String longestCommonSubsequence(List<String> list1, List<String> list2){
        String longest  =   "";
        for(int i=0;i<list1.size();i++){
            for (int j=0;j<list2.size();j++){
                if(list1.get(i).length() > longest.length()){
                    if((list1.get(i).length() == list2.get(j).length()) && list1.get(i).equals(list2.get(j))){
                        longest = list1.get(i);
                    }
                }
            }
        }
        return longest;
    }
    public static String lcs(String x, String y) {
        lcs2(x, "");
        al2 = new ArrayList<>(al);
        al = new ArrayList<>();
        lcs2(y,"");
        return longestCommonSubsequence(al,al2);
    }
}
