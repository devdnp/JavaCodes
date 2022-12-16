package d100._4day;

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};//{8, 4, 2, 1};
        System.out.println(countInv(arr));
    }

    static int countInv(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
