package leet_code._daily_prob.may23;
//01-May-2023
//#1491

import java.util.Arrays;

public class AvgSalaryExcludingMinMax {

    public static void main(String[] args) {
        int[] salary = {4000,3000,1000,2000};
        System.out.println(average(salary));
    }
    public static double average(int[] salary) {
        double avg = 0, sum = 0;
        Arrays.sort(salary);
        for(int i=1; i<salary.length-1;i++){
            sum += salary[i];
        }
        avg = (double)sum/(salary.length-2);
        return avg;
    }
}