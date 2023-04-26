package leet_code._daily_prob.apr23;
//26-Apr
//#258
public class AddDigits {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(addDigits(num));
    }
    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}