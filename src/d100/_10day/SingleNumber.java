package d100._10day;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    static int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap();

        for (int number : nums) {
            map.put(number, !map.getOrDefault(number, false));
        }

        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return Integer.MIN_VALUE;
    }
}
