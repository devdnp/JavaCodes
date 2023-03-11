package leet_code.easy;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int k = 2;
        System.out.println(findKthPositive(arr,k));
    }
    public static int findKthPositive(int[] arr, int k)
    {
        int count=0,inc=0;
        int[] res=new int[1000];
        for(int i=1;i<=(1000+arr.length);i++)
        {
            if(count<arr.length)
            {
                if(arr[count]==i)
                {
                    count++;
                    continue;
                }
                else
                {
                    res[inc]=i;
                    inc++;
                }
            }
            else
            {
                res[inc]=i;
                inc++;
            }
        }
        return res[k-1];
    }
}
