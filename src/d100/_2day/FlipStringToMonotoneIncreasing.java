package d100._2day;
//926
public class FlipStringToMonotoneIncreasing {
    static int minFlipsMonoIncr(String s) {
        int m = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++m;
            }
        }
        int ans = m;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ans = Math.min(ans, --m);
            } else {
                ++m;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "00110";
        System.out.println(minFlipsMonoIncr(s));
    }
}
