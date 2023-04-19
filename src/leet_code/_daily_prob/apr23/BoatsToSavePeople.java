package leet_code._daily_prob.apr23;

import java.util.Arrays;
//03-Apr
//881
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;

        Arrays.sort(people);

        for (int i = 0, j = people.length - 1; i <= j; ++ans) {
            int remain = limit - people[j--];
            if (people[i] <= remain)
                ++i;
        }

        return ans;
    }
}
