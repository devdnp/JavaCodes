package leet_code._daily_prob;
//#55
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};//{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    static boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;

        int max = nums[0];
        for(int i=0; i<nums.length; i++){
            if(max <= i && nums[i] == 0)
                return false;
            if(i + nums[i] > max){
                max = i + nums[i];
            }

            if(max >= nums.length-1)
                return true;
        }

        return false;
    }
}
