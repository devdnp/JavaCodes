package leet_code.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }

    static int searchInsert(int[] nums, int target) {
        int f=0;
        int l=nums.length-1;
        while(f<=l){
            int m = (f+l)/2;
            if(nums[m]==target){
                return m;
            }
            else if(target>nums[m]){
                f=m+1;
            }else{
                l=m-1;
            }
        }
        return l+1;
    }
}
