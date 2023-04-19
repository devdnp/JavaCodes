package leet_code._daily_prob.apr23;

//01-Apr
//704
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int st=0, ls=nums.length-1;
        while(st<=ls){
            int md = (st + (ls-st)/2);
            if(nums[md]==target) return md;
            else if(nums[md]>target) ls=md-1;
            else st=md+1;
        }
        return -1;
    }
}
