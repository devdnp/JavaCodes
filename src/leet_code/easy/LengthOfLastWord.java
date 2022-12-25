package leet_code.easy;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";//"Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    static int lengthOfLastWord(String s) {
        s = s.trim();
        String word = s.substring(s.lastIndexOf(" ")+1);
        return word.length();

    }
}
