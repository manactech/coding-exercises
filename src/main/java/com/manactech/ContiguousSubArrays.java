package com.manactech;
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class ContiguousSubArrays {

    // Add any helper functions you may need here


    int[] countSubarrays(int[] arr) {
        // Write your code here
        System.out.println("----");
        printIntegerArray(arr);
        System.out.println();
        int[] output = new int[arr.length];
        int[] lop = new int[arr.length];
        int[] rop = new int[arr.length];

        int lhv = arr[0];
        int lhsl = 0;
        int lhi = 0;

        int rhv = arr[arr.length-1];
        int rhsl = 0;
        int rhi = arr.length-1;

        for(int li=1; li < arr.length; li++){

            int lcv = arr[li];
            int lcsl = 0;
            int ri = arr.length-1-li;
            int rcv = arr[ri];
            int rcsl = 0;

            if(lcv > lhv){
                lcsl = li - lhi + lhsl;
                lhi = li;
                lhsl = lcsl;
                lhv = lcv;
            }else if (lcv > arr[li-1]){
                lcsl = 1;
            }

            if(rcv > rhv){
                rcsl = rhi - ri + rhsl;
                rhi = ri;
                rhsl = rcsl;
                rhv = rcv;
            }else if (rcv > arr[ri+1]){
                rcsl = 1;
            }
            System.out.println(String.format("li %d lcv %d lcsl %d lhi %d lhv %d lhsl %d",
                    li,lcv,lcsl,lhi,lhv,lhsl));

            System.out.println(String.format("ri %d rcv %d rcsl %d rhi %d rhv %d rhsl %d",
                    ri,rcv,rcsl,rhi,rhv,rhsl));
            lop[li] = lcsl;
            rop[ri] = rcsl;

            output[li] = lcsl + rop[li] + 1;
            output[ri] = rcsl + lop[ri] + 1;

            printIntegerArray(output);
            System.out.println("----");

        }

        return output;

    }






    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }
    public void run() {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new ContiguousSubArrays().run();
    }
}