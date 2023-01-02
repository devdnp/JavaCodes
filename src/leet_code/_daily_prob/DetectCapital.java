package leet_code._daily_prob;

public class DetectCapital {
    public static void main(String[] args) {
        String word = "FlaG";
        System.out.println(detectCapitalUse(word));
    }
    static boolean detectCapitalUse(String word) {
        int count=0;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(c>='A' && c<='Z'){
                count++;
            }
            if(!(count==0 || (count==1 && word.charAt(0)>='A' && word.charAt(0)<='Z') || count==i+1)){
                return false;
            }
        }
        return true;
    }
}
