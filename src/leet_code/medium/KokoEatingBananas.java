package leet_code.medium;
//875
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low= 1;
        int hi = 1000000000;

        while(low< hi){
            int mid = low + (hi - low) / 2;
            if(canEatInTime(piles, mid, h)) hi = mid;
            else low = mid + 1;
        }
        return low;
    }
    public static boolean canEatInTime(int piles[], int k, int h){
        int time = 0;
        for(int p : piles){
            time+=(p-1)/k+1;
            if(time>h){
                break;
            }
        }
        return time <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}
