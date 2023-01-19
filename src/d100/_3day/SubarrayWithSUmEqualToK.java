package d100._3day;
//974
import java.util.HashMap;

public class SubarrayWithSUmEqualToK {
    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums,k));
    }
    static int subarraysDivByK(int[] nums, int k) {

        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            int mod = (sum % k + k) % k;
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}
