package leet_code.medium;
//2187

public class MinTimeToCompleteTrips {

    public static void main(String[] args) {
        int[] time = {1,2,3};
        int totalTrips = 5;
        System.out.println(minimumTime(time,totalTrips));
    }
    public static long minimumTime(int[] time, int totalTrips) {
        long lo = 0, hi = 100000000000000L;
        while(lo<hi){
            long req=(lo+hi)/2;
            long trips = 0;
            for (int t : time) {
                trips += req / t;
            }
            if (trips < totalTrips) {
                lo = req + 1;
            }else {
                hi = req;
            }
        }
        return lo;
    }
}
