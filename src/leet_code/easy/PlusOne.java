package leet_code.easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
//    static int[] plusOne(int[] digits) {
//        int n = digits.length-1;
//
//        while (n>=0 && digits[n]==9){
//            n--;
//        }
//        if(n==-1){
//            int[] result = new int[digits.length+1];
//            result[0] = 1;
//            return result;
//        }
//        int[] result = new int[digits.length];
//        result[n] = digits[n] + 1;
//        for (int i = 0; i < n; i++) {
//            result[i] = digits[i];
//        }
//        return result;
        static int[] plusOne(int[] digits) {

            int n = digits.length;
            for(int i=n-1; i>=0; i--) {
                if(digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }

                digits[i] = 0;
            }

            int[] newNumber = new int [n+1];
            newNumber[0] = 1;

            return newNumber;
        }
//    }
}
