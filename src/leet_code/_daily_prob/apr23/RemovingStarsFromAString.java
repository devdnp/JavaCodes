package leet_code._daily_prob.apr23;
//11Apr
//#2390
public class RemovingStarsFromAString {

    public static void main(String[] args) {
        String s = "erase*****";//"leet**cod*e";
        System.out.println(removeStars(s));
    }
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (final char c : s.toCharArray())
            if (c == '*')
                sb.deleteCharAt(sb.length() - 1);
            else
                sb.append(c);
        return sb.toString();
    }
}
