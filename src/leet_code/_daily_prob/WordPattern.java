package leet_code._daily_prob;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        System.out.println(wordPattern(pattern,s));
    }
    static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] str = s.split(" ");

        if(str.length != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++){
            char a = pattern.charAt(i);
            if(!map.isEmpty() && map.containsKey(a) && !map.get(a).equals(str[i])) return false;

            if(!map.isEmpty() && map.containsKey(a) && map.get(a).equals(str[i])) continue;

            if(!map.isEmpty() && map.containsValue(str[i])) return false;

            map.put(a,str[i]);
        }
        return true;
    }
}
