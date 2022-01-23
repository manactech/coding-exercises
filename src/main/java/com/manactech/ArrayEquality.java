package com.manactech;

import java.util.*;
// Add any extra import statements you may need here


class ArrayEquality {

    // Add any helper functions you may need here


    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        if(array_a.length != array_b.length){
            return false;
        }
        Map<Integer, int[]> elementCounts= new HashMap<>();
        for(int i=0; i<array_a.length; i++){
            int arrayAVal = array_a[i];
            int arrayBVal = array_b[i];

            if(arrayAVal == arrayBVal){
                incrementCount(elementCounts, arrayAVal, true, 0);
            }else{
                incrementCount(elementCounts, arrayAVal, false, 0);
                incrementCount(elementCounts, arrayBVal, false, 1);
            }
        }

        for(int[] counts: elementCounts.values()){
            if(counts[0] != counts[1]){
                return false;
            }
        }

        return true;

    }

    private void incrementCount(Map<Integer, int[]> elementCounts, int arrayAVal, boolean sameElements, int index) {
        int[] counts = elementCounts.get(arrayAVal);
        if(counts == null){
            counts =  new int[]{0,0};
        }
        if(sameElements){
            counts[0]++;
            counts[1]++;
        }else{
            counts[index]++;
        }

        elementCounts.put(arrayAVal, counts);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] array_a_1 = {1, 2, 3, 4};
        int[] array_b_1 = {1, 4, 3, 2};
        boolean expected_1 = true;
        boolean output_1 = areTheyEqual(array_a_1, array_b_1);
        check(expected_1, output_1);

        int[] array_a_2 = {1, 2, 3, 4};
        int[] array_b_2 = {1, 4, 3, 3};
        boolean expected_2 = false;
        boolean output_2 = areTheyEqual(array_a_2, array_b_2);
        check(expected_2, output_2);
        // Add your own test cases here

    }

    public static void main(String[] args) {
        new ArrayEquality().run();
    }
}