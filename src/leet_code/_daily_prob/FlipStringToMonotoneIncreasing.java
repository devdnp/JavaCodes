package leet_code._daily_prob;
//926
public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
    static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] counts = new int[n];
        counts[0] = s.charAt(0) - '0';
        for (int i = 1; i < n; i++) {
            counts[i] = counts[i - 1] + s.charAt(i) - '0';
        }

        int lastIndex = n - 1, antiLength = lastIndex,
                last = counts[lastIndex], min = Math.min(last, n - last),
                count;

        for (int i = 0; i < lastIndex; i++) {
            count = counts[i];
            min = Math.min(min, (count << 1) + antiLength - last);
            antiLength--;
        }

        return min;
    }
}
