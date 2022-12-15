package d100._5day;

public class BinarySum {
    static String addBinary(String a, String b) {
        int one = Integer.parseInt(a, 2);
        int two = Integer.parseInt(b, 2);

        int sum = one + two;
        return Integer.toBinaryString(sum);
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1001";
        System.out.println(addBinary(a, b));
    }
}
