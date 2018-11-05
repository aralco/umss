package bo.edu.umss.algorithms.competitions.contest5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//UVA 11369 - Shopaholic
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2354
//https://github.com/shailesh1001/uva-2/blob/master/UVa11369_Shopaholic.java
//https://github.com/marioyc/Online-Judge-Solutions/blob/master/UVA/Contest%20Volumes/11369%20-%20Shopaholic.cpp
//http://mypaper.pchome.com.tw/zerojudge/post/1322898030
//https://uva.onlinejudge.org/board/viewtopic.php?t=26159

public class Main_E_Shopaholic {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for(int i=1;i<=t;i++)   {
            int n = Integer.parseInt(bufferedReader.readLine());
            String pricesLine = bufferedReader.readLine();
            String[] pricesArray = pricesLine.split(" ");
            int[] prices = new int[n];
            int total = 0;
            for(int j=0;j<n;j++) {
                prices[j] =  Integer.valueOf(pricesArray[j]);
            }
            Arrays.sort(prices);
            for (int k = prices.length - 1; k >= 0; k--) {
                if ((prices.length - k) % 3 == 0)
                    total = total + prices[k];
            }
            System.out.println(total);
        }
    }
}
