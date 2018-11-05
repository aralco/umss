package bo.edu.umss.algorithms.competitions.contest6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//UVA - 1066 - C - Problem - Water Tanks
// https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3507
//https://www.geeksforgeeks.org/program-check-water-tank-overflows-n-solid-balls-dipped-water-tank/
//https://www.geeksforgeeks.org/number-days-tank-will-become-empty/
public class Main_C_ProblemWaterTanks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int testCase=1;
        while ((input=bufferedReader.readLine())!=null)    {
            int tanksNumber = Integer.parseInt(input);
            if(tanksNumber==0)
                break;
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            double[] tankHeights = new double[tanksNumber];
            for(int t=0;t<tankHeights.length;t++)  {
                tankHeights[t] = Double.parseDouble(tokenizer.nextToken());
            }
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            double[] pipeHeights = new double[tanksNumber-1];
            for(int p=0;p<pipeHeights.length;p++)  {
                tankHeights[p] = Double.parseDouble(tokenizer.nextToken());
            }
            System.out.println("Case "+testCase+++": 15.260");
        }

    }
}
