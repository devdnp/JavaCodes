package d100._2day;

public class MinMaxPair {
    static class Pair{
        int min;
        int max;
    }
    static Pair getMinMax(int[] arr, int low, int high){
        Pair minmax = new Pair();
        Pair minmaxL = new Pair();
        Pair minmaxR = new Pair();
        int mid;

        if(low==high){
            minmax.min = arr[0];
            minmax.max = arr[0];
            return minmax;
        }
        if(high==low+1){
            if(arr[low]<arr[high]){
                minmax.min = arr[low];
                minmax.max = arr[high];
            }else{
                minmax.min = arr[high];
                minmax.max = arr[low];
            }
            return minmax;
        }
        mid = (low+high)/2;
        minmaxL = getMinMax(arr, 0, mid);
        minmaxR = getMinMax(arr, mid+1, high);
        if(minmaxL.min < minmaxR.min){
            minmax.min = minmaxL.min;
        }else{
            minmax.min = minmaxR.min;
        }
        if(minmaxL.max > minmaxR.max){
            minmax.max = minmaxL.max;
        }else{
            minmax.max = minmaxR.max;
        }
        return minmax;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,11,3,7,4,0,1,21,16,8,0};
        Pair minmax = getMinMax(arr, 0, arr.length-1);
        System.out.println(minmax.min+" & "+minmax.max);
    }
}
