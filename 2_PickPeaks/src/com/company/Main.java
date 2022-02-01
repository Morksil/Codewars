package com.company;

import java.util.*;
/*
* In this kata, you will write a function that returns the positions and the values of the "peaks" (or local maxima)
* of a numeric array.

For example, the array arr = [0, 1, 2, 5, 1, 0] has a peak at position 3 with a value of 5 (since arr[3] equals 5).

The output will be returned as a ``Map<String,List>with two key-value pairs:"pos"and"peaks". If there is no peak
* in the given array, simply return {"pos" => [], "peaks" => []}`.

Example: pickPeaks([3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3]) should return {pos: [3, 7], peaks: [6, 3]} (or equivalent in other languages)

All input arrays will be valid integer arrays (although it could still be empty), so you won't need to validate the input.

The first and last elements of the array will not be considered as peaks
* (in the context of a mathematical function, we don't know what is after and before and therefore, we don't know if it is a peak or not).

Also, beware of plateaus !!! [1, 2, 2, 2, 1] has a peak while [1, 2, 2, 2, 3] and [1, 2, 2, 2, 2] do not.
* In case of a plateau-peak, please only return the position and value of the beginning of the plateau.
* For example: pickPeaks([1, 2, 2, 2, 1]) returns {pos: [1], peaks: [2]} (or equivalent in other languages)*/
public class Main {

    public static void main(String[] args) {
	    int [] tablica = {
                3,2,3,6,4,1,2,3,2,1,2,2,2,1
        };
        getPeaks_test(tablica);
    }
        //getPeaks();
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        boolean isPlateauPeak = false;
        List<Integer> peaks = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();
        Map<String,List<Integer>> peaksPositions = new HashMap<>();
        for(int i=1;i<arr.length - 1;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                peaks.add(arr[i]);
                positions.add(i);
            }else if(arr[i] > arr[i-1] && arr[i] == arr[i+1]){
                int plateauPeak = i;
                for(int j = i; j<arr.length - 1;j++){
                    if(arr[j] == arr[j+1] && (j+1 != arr.length -1)){
                        isPlateauPeak = true;
                    }else if(arr[j] < arr[j+1]){
                        isPlateauPeak = false;
                        break;
                    }else if(arr[j] > arr[j+1] && isPlateauPeak){
                        peaks.add(arr[j]);
                        positions.add(i);
                        break;
                    }
                }
            }
        }
        /*peaksPositions.put("pos", positions);
        peaksPositions.put("peaks", peaks);

        System.out.println("Peaks"+Arrays.toString(peaks.toArray()));
        System.out.println("Positions"+Arrays.toString(positions.toArray()));

        for (Map.Entry<String, List<Integer>> me :
                peaksPositions.entrySet()) {

            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }*/
        return peaksPositions;
    }
    public static void getPeaks_test(int[] arr) {
        boolean isPlateauPeak = false;
        List<Integer> peaks = new ArrayList<>();
        List<Integer> positions = new ArrayList<>();
        Map<String,List<Integer>> peaksPositions = new HashMap<String, List<Integer>>();
        for(int i=1;i<arr.length - 1;i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                peaks.add(arr[i]);
                positions.add(i);
            }else if(arr[i] > arr[i-1] && arr[i] == arr[i+1]){
                System.out.println("Chyba plasko");
                int plateauPeak = i;
                for(int j = i; j<arr.length - 1;j++){
                    if(arr[j] == arr[j+1] && (j+1 != arr.length -1)){
                        System.out.println("test");
                        isPlateauPeak = true;
                    }else if(arr[j] < arr[j+1]){
                        isPlateauPeak = false;
                        break;
                    }else if(arr[j] > arr[j+1] && isPlateauPeak){
                        peaks.add(arr[j]);
                        positions.add(i);
                        break;
                    }
                }
            }
        }
        peaksPositions.put("pos", positions);
        peaksPositions.put("peaks", peaks);

        for (Map.Entry<String, List<Integer>> me :
                peaksPositions.entrySet()) {

            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }

    }
}
