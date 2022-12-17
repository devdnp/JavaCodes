package leet_code.easy;

public class Sqrt {
    static int mySqrt(int x) {

        if(x<2) return x;
        int l = x/2;
        int s = 1;

        while(s<=l){
            int m = (s+l)/2;
            if((long)m*m>x){
                l=m-1;
            }else{
                s=m+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int num = 85;
        System.out.println(mySqrt(num));
    }
}
