package leet_code._daily_prob.mar23;
//02-Mar
//#443
public class StringComparison {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
        int ans = 0;

        for (int i = 0; i < chars.length;) {
            final char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }
            chars[ans++] = letter;
            if (count > 1)
                for (final char c : String.valueOf(count).toCharArray())
                    chars[ans++] = c;
        }

        return ans;
    }
}