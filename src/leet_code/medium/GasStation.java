package leet_code.medium;
//134
public class GasStation {
    static int canCompleteCircuit(int[] gas, int[] cost) {

        int[] sum=new int[gas.length+1];
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=gas.length-1;i>=0;i--){
            sum[i]=sum[i+1]+gas[i]-cost[i];
            if(max<sum[i]){
                max=sum[i];
                index=i;
            }
        }
        if(sum[0]<0) return -1;
        return index;
    }

    public static void main(String[] args) {
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
