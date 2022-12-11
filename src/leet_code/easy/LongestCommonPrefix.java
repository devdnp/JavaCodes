package leet_code.easy;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return"";

        String ans = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(ans)!=0){
                ans = ans.substring(0, ans.length()-1);

                if(ans.isEmpty()) return "";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"}; //{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
