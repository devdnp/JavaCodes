package leet_code._daily_prob.apr23;
//27-Apr
//#319
import java.lang.Math;

public class BulbSwitcher {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(bulbSwitch(n));
    }
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}