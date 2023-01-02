package leet_code.easy;

public class DetectCapital {
    public static void main(String[] args) {
        String word="JavaProgramming";//""Java";
        System.out.println(detectCapitalUse(word));
    }
    static boolean detectCapitalUse(String word) {
        if(word.toLowerCase().equals(word)) return true;
        else if(word.toUpperCase().equals(word)) return true;
        else if((word.substring(0,1).toUpperCase()+word.toLowerCase().substring(1,word.length())).equals(word)) return true;
        return false;
    }
}
