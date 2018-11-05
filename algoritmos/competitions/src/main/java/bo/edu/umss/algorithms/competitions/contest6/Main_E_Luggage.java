package bo.edu.umss.algorithms.competitions.contest6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//UVA 10664 - E - Luggage
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1605
public class Main_E_Luggage {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(bufferedReader.readLine());
        for(int i=1;i<=m;i++)   {
            String input = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            int[] suitcases = new int[stringTokenizer.countTokens()];
            int sumN = 0;
            for(int l=0;l<suitcases.length;l++) {
                suitcases[l] = Integer.parseInt(stringTokenizer.nextToken());
                sumN = sumN + suitcases[l];
            }
            //System.out.println(Arrays.toString(suitcases));
            boolean isPossible = false;
            if(sumN<=200 && (sumN%2)==0)  {
                int w1 = sumN/2;
                int w2 = sumN/2;
                Arrays.sort(suitcases);
                for(int x=suitcases.length-1;x>=0;x--)  {
                    if(w1>=suitcases[x])    {
                        w1 = w1 - suitcases[x];
                        suitcases[x] = 0;
                    }
                    else if(w2>=suitcases[x])    {
                        w2 = w2 - suitcases[x];
                        suitcases[x] = 0;
                    }
                }
                if(w1==0 && w2==0)
                    isPossible = true;
            }
            System.out.println(isPossible?"YES":"NO");
        }
    }
}
//1 2 1 2 1
//2 3 4 1 2 5 10 50 3 50
//3 5 2 7 1 7 5 2 8 9 1 25 15 8 3 1 38 45 8 1
//1 1 3 7
