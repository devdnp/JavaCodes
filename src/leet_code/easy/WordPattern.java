package leet_code.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(wordPattern(pattern,s));
    }
    static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] animals = s.split(" ");
        if (pattern.length() != animals.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String animal = animals[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(animal)) return false;
            } else {
                if (map.containsValue(animal)) return false;
                map.put(c, animal);
            }
        }
        return true;
    }
}
