package com.manactech;

public class RotationalCipher {
    // Add any helper functions you may need here
    private int getWeight(char[] chars, char inputChar){
        int weight = -1;
        for(int j=0; j<chars.length; j++){
            if(chars[j] == inputChar){
                weight = j;
                break;
            }
        }
        return weight;
    }

    private char getEncryptedChar(char[] chars, int weight, int srf){
        int newWeight = weight + srf;
        if(newWeight > chars.length){
            newWeight = newWeight - chars.length;
        }
        //System.out.println(String.format("%d,%d,%s",weight, newWeight, chars[newWeight]));
        return chars[newWeight];
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here

        if(rotationFactor == 0){
            return input;
        }

        char[] abcs = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        char[] capAbcs = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        char[] nums = {'0','1','2','3','4','5','6','7','8','9'};

        char[] inputChars = input.toCharArray();
        char[] encryptedChars = new char[inputChars.length];

        for(int i=0; i<inputChars.length; i++){
            char inputChar = inputChars[i];

            int weight = getWeight(abcs, inputChar);
            if(weight >=0){
                encryptedChars[i] = getEncryptedChar(abcs, weight, rotationFactor % abcs.length);
                continue;
            }

            weight = getWeight(capAbcs, inputChar);
            if(weight >=0){
                encryptedChars[i] = getEncryptedChar(capAbcs, weight, rotationFactor % capAbcs.length);
                continue;
            }

            weight = getWeight(nums, inputChar);
            if(weight >=0){
                encryptedChars[i] = getEncryptedChar(nums, weight, rotationFactor % nums.length);
                continue;
            }
            encryptedChars[i] = inputChar;
        }

        return String.valueOf(encryptedChars);
    }



    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
