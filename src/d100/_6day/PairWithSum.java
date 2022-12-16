package d100._6day;

public class PairWithSum {
    public static void main(String args[])
    {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 6;
        System.out.println(getPairsCount(arr, sum));
    }
    static int getPairsCount(int[] arr, int sum){
        int count  = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
//                int result = arr[i]+arr[j];
//                if (result==sum) ++count;
                if(arr[i]+arr[j]==sum){
                    count++;
                }
            }
        }
        return count;
    }
}
