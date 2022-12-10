package leet_code.easy;

public class PalindromeNum {
    public static void main(String[] args) {
        int x = 121; //123;
        System.out.println(isPalindrome(x));
    }

    static boolean isPalindrome(int x) {
        if(x < 0 || (x>0 && x%10 == 0))
            return false;
        int rev = 0;
        while(x>rev){
            rev = rev*10 + x%10;
            x /= 10;
        }
        return x == rev || x == rev/10;
    }
}
