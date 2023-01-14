package d100._2day;

public class LexicographicallySmallestEquivalentString {
    static int[] demo = new int[26];
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0; i<26; i++){
            demo[i]=i;
        }
        for(int i=0; i<s1.length(); i++){
            union(s1.charAt(i)-'a', s2.charAt(i)-'a');
        }
        String answer = "";

        for(char c : baseStr.toCharArray()){
            answer += (char)(getIt(c-'a')+'a');
        }
        return answer;
    }

    static void union(int x,  int y){
        x = getIt(x);
        y = getIt(y);

        if(x==y){
            return;
        }
        if(x<y){
            demo[y]=x;
        }else{
            demo[x]=y;
        }
    }
    static int getIt(int x){
        if(demo[x]==x){
            return x;
        }
        return demo[x]=getIt(demo[x]);
    }

    public static void main(String[] args) {
        String s1 = "leetcode", s2 = "programs", baseStr = "sourcecode";
        System.out.println(smallestEquivalentString(s1,s2,baseStr));
    }
}
