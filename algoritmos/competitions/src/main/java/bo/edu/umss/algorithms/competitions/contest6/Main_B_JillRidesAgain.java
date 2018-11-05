package bo.edu.umss.algorithms.competitions.contest6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//UVA - 507 - B - Jill Rides Again
// https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=448
//https://github.com/morris821028/UVa/blob/master/volume005/507%20-%20Jill%20Rides%20Again.cpp#L11
//https://saicheems.wordpress.com/2013/07/19/uva-507-jill-rides-again/
//http://ruslanledesma.com/2016/03/05/jill-rides-again.html
//http://www.questtosolve.com/browse.php?vol=5
public class Main_B_JillRidesAgain {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int route = Integer.parseInt(bufferedReader.readLine());
        for(int r=1;r<=route;r++)   {
            int tmp = 1;
            int start = Integer.MAX_VALUE;
            int end = Integer.MAX_VALUE;
            int sum = 0;
            int result = 0;
            int stop = Integer.parseInt(bufferedReader.readLine());
            int assessment;
            for(int i=2;i<=stop;i++)    {
                assessment = Integer.parseInt(bufferedReader.readLine());
                sum = sum + assessment;
                if(sum < 0)    {
                    sum = 0;
                    tmp = i;
                }
                if(sum >= result) {
                    if(sum > result || (sum == result && (i - tmp > end - start))) {
                        start = tmp;
                        end = i;
                    }
                    result = sum;
                }
            }
            if(result>0)
                System.out.println("The nicest part of route "+r+" is between stops "+start+" and "+end);
            else
                System.out.println("Route "+r+" has no nice parts");
        }
    }
}
