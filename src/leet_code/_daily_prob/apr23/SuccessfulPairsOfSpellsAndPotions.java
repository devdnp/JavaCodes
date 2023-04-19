package leet_code._daily_prob.apr23;
//02-Apr
//2300
import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {

    public static void main(String[] args) {
        int[] spells = {5,1,3}, potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells,potions,success)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; ++i)
            ans[i] = potions.length - firstIndexSuccess(spells[i], potions, success);

        return ans;
    }

    // First index i s.t. spell * potions[i] >= success
    private static int firstIndexSuccess(int spell, int[] potions, long success) {
        int l = 0;
        int r = potions.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if ((long) spell * potions[m] >= success)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }
}
