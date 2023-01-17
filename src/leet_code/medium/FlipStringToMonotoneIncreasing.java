package leet_code.medium;
//926
public class FlipStringToMonotoneIncreasing {
    static int minFlipsMonoIncr(String s) {
        int ans = 0, num = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(num, ans + 1);
            } else {
                ++num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
