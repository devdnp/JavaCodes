package leet_code.easy;
//136
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        int result = 0;
        for(int i : nums){
            result ^= i;
        }
        return result;
    }
}
