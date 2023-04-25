package leet_code._daily_prob.apr23;

import java.util.TreeSet;
//25-Apr
//#2336
public class SmallestNumberInfiniteSet {

    public static void main(String[] args) {

    }
    public static int popSmallest() {
        if (added.isEmpty())
            return curr++;
        final int min = added.first();
        added.remove(min);
        return min;
    }

    public void addBack(int num) {
        if (num < curr)
            added.add(num);
    }

    private static int curr = 1;
    private static TreeSet<Integer> added = new TreeSet<>();
}
