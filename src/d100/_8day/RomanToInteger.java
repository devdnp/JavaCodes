package d100._8day;

import java.util.Map;
import java.util.TreeMap;

public class RomanToInteger {
    static String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>((a, b) -> (b - a));
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        String result = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            while (num >= entry.getKey()) {
                result += entry.getValue();
                num -= entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
