package leet_code.medium;

import java.util.HashMap;
import java.util.Map;

public class MinRoundToCompleteAllTasks {
    public static void main(String[] args) {
        int[] tasks ={2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(tasks));
    }
    static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int minimumRounds = 0;
        for (int count : freq.values()) {
            if (count == 1) {
                return - 1;
            }

            if (count % 3 == 0) {
                minimumRounds += count / 3;
            } else {
                minimumRounds += count / 3 + 1;
            }
        }

        return minimumRounds;
    }
}
