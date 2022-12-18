package leet_code._daily_prob;

import java.util.Arrays;

public class DailyTemperatures {
    static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Arrays.fill(answer, 0);
        for (int i = 0; i < temperatures.length-1; i++) {
            int count = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                if(temperatures[i]<temperatures[j]){
                    count+=1;
                    break;
                }
                else if (temperatures[i]>temperatures[j]){
                    if(j==temperatures.length-1){count=0; break;}
                    else count+=1;

                }
                else count+=0;
            }
            answer[i]=count;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
