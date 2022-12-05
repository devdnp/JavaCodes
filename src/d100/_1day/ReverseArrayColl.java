package d100._1day;

import java.util.Arrays;
import java.util.Collections;

public class ReverseArrayColl {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9};

        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
