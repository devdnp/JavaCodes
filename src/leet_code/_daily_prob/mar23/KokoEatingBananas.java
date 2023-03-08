package leet_code._daily_prob.mar23;
//875
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        long total=0;
        for(int i:piles){
            total+=i;
        }
        int l=Math.max(1,lowerBound(total,h));
        int r=upperBound(n,h,total);
        while(l<r){
            int mid=(l+r)/2;
            if(canEat(piles,mid,h)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return r;
    }
    public static int upperBound(int piles,int h,long total){
        total-=(piles-1);
        h-=(piles-1);
        return (int)Math.ceil(total*1.0 / h);
    }
    public static int lowerBound(long total,int h){
        return (int)Math.floor(total*1.0/h);
    }
    public boolean canEat(int []piles,int k,int h){
        int total=0;
        for(int i=0;i<piles.length;i++){
            total+=piles[i]/k+(piles[i]%k!=0?1:0);
            if(total>h){
                return false;
            }
        }

        return true;

    }
}
