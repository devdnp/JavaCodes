package leet_code._daily_prob;
//131
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static boolean dp[][];//global array for finding whether the String is palindromic or not
    static String str_arr[][];
    static List <List< String >> rv;//return value
    static int len;
    static ArrayList<String> helper;

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    public static void fill_palindromic_arr(String str) {
        len = str.length();
        dp = new boolean[len][len];
        str_arr = new String[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = str.charAt(i) == str.charAt(i + 1);
        }
        for (int g = 2; g < len; g++) {
            for (int si = 0; si < len; si++) {
                int ei = si + g;
                if (ei < len && str.charAt(si) == str.charAt(ei)) {
                    dp[si][ei] |= dp[si + 1][ei - 1];
                }
            }
        }
        //creating and storing only the palindromic substring
        // do not create each and every substring otherwise exactly O(N*N*N) time will be taken even for the best case
        //for example when length is 16 and all characters are unique in case only 16 palindromic strings need to be created
        //whereas if we create all the strings steps taken would be N*N for number of substrings and N for creation of each substring
        //i.e 16*16*16 along with that it will also strain java internpool for maintaining so many strings
        //also there would be lot of garbage for the garbage collector to collect
        // check https://en.wikipedia.org/wiki/String_interning

        for (int si = 0; si < len; si++) {
            for (int ei = si; ei < len; ei++) {
                if(dp[si][ei])
                    str_arr[si][ei] = str.substring(si, ei + 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        rv = new ArrayList<>();
        fill_palindromic_arr(s);
        helper = new ArrayList<String>(len);
        fill(0);
        return rv;
    }

    public static void fill(int si) {
        // this function is supposed to fill the complete List for string defined from si
        if (si >= len) {
            //base case
            rv.add(new ArrayList<String>(helper));
            return;
        }
        for (int ei = si; ei < len; ei++) {
            if (dp[si][ei]) {
                // the string was a palindrome
                //consume the palindrome equivalent to doing work for own
                helper.add(str_arr[si][ei]);

                //having faith on recursion that it will work for the subquery
                fill(ei + 1);

                //clearing the arraylist for another call
                //this string has been explored and used, now it can not be used
                //because when we return from stack trace at that time our helper
                //arraylist should not have plaindromes from index beyond its call
                helper.remove(helper.size()-1);
            }
        }
    }
}
