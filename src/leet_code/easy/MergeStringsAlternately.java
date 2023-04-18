package leet_code.easy;

//1768
public class MergeStringsAlternately {
    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";
        System.out.println(mergeAlternately(word1,word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        String res = "";
        int i=0, j=0;

        while(i<word1.length() || j<word2.length()){
            if(i<word1.length()){
                res += word1.charAt(i++);
            }
            if(j<word2.length()){
                res += word2.charAt(j++);
            }
        }
        return res;
    }
}