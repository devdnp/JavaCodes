package leet_code._daily_prob.may23;
//02-May-2023
//#1822
public class SignOfProductArray {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,3,2,1};
        System.out.println(arraySign(nums));
    }
    public static int arraySign(int[] nums) {
        int countMinus = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] == 0){
                return 0; // return 0 if we found a 0 in the array
            }
            if(nums[i] < 0){
                countMinus++; //increment the count wehn we found a negative number
            }
        }
        //check if countMinus is multiple of 2 then return 1 else return -1
        return countMinus % 2 == 0 ? 1 : -1;
    }
}