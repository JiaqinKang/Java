package com.company;

import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> numbers = new TreeMap<>();

        //random sorted array between 1-100, length 200
        int [] arr = {1,2,2,3,5,5,6,6,7,7,7,7,7,8,10,10,10,10,10,11,11,12,12,13,13,14,
                      15,16,16,16,16,16,16,17,17,17,18,18,19,19,19,20,20,21,21,21,23,23,
                      24,24,24,25,25,27,28,28,29,29,29,29,29,29,29,30,30,30,32,32,32,32,
                      33,33,33,35,35,36,36,36,36,36,37,37,37,38,38,39,39,39,39,40,40,41,
                      41,41,42,42,42,44,44,44,44,45,46,47,47,48,48,49,49,49,50,51,52,52,
                      53,53,54,54,54,55,55,57,57,58,58,59,59,59,60,60,62,62,62,62,62,62,
                      63,63,64,64,65,65,65,65,67,68,68,69,69,70,70,71,71,73,74,75,76,76,
                      76,77,77,78,78,79,79,80,81,81,81,82,82,84,84,86,86,86,87,88,88,88,
                      89,89,89,89,90,90,92,93,93,93,95,95,95,96,96,96,96,98,99,100};

        //iterate the array to find frequency of each number in arr
        for (var i =0 ; i < arr.length;i++){
            //position
            int nextNumber = arr[i];
            //checking if statement to find frequency and when found +1 to the frequency
            if (numbers.containsKey(arr[i])){
                numbers.put(nextNumber,numbers.get(nextNumber)+1);
            }
            else{ //number that appeared once will have a frequency to 1
                numbers.put(arr[i],1);
            }
        }
        //out put the map
        System.out.println(numbers);
    }
}
