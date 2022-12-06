package d100._2day;

public class MinMax {
    public static void main(String[] args) {
        int[] arr = {9,5,11,3,7,4,0,1,21,16,8,0};
        int min = arr[0];
        int max = arr[0];

        if(arr.length==1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min = arr[i];
            }else if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Min: "+min+"\nMax: "+max);
    }
}
