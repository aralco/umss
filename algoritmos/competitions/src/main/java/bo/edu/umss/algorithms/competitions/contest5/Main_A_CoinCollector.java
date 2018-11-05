package bo.edu.umss.algorithms.competitions.contest5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//UVA 11264 - Coin Collector
// https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2231
//http://www.algorithmist.com/index.php/UVa_11264
//https://www.youtube.com/watch?v=wiZ9Kp48Rcg
//https://github.com/PuzzlesLab/UVA/blob/master/King/11264%20Coin%20Collector.java
//https://github.com/ajahuang/UVa/blob/master/UVa%2011264%20-%20Coin%20Collector.cpp
//http://problemasdeprogramacao.blogspot.com/2016/12/uva-coin-collector-solution.html
//https://github.com/ajahuang/UVa/blob/master/UVa%2011264%20-%20Coin%20Collector.cpp
//https://naivesolution.wordpress.com/2014/11/12/uva-11264-coin-collector-solution/
//http://naivered.github.io/2018/03/20/Problem_Solving/UVa/UVa-11264-Coin-Collector/

public class Main_A_CoinCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bufferedReader.readLine());
        for(int i=1;i<=t;i++)   {
            int n = Integer.valueOf(bufferedReader.readLine());
            String coinsLine = bufferedReader.readLine();
            String[] coinsLineArray = coinsLine.split(" ");
            int[] coins = new int[n];
            int x = 0;
            for(int j=0;j<n;j++) {
                coins[j] =  Integer.valueOf(coinsLineArray[j]);
                x = x + coins[j];
            }
            int sum=1;
            int maxNumberCoins = coins.length > 1? 2:1;
            for(int k=1;k<coins.length-1;k++)   {
                if(sum+coins[k]<coins[k+1]) {
                    sum = sum + coins[k];
                    maxNumberCoins++;
                }
            }


            System.out.println(maxNumberCoins);
        }
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.valueOf(bufferedReader.readLine());
//        for(int i=1;i<=t;i++)   {
//            int n = Integer.valueOf(bufferedReader.readLine());
//            String coinsLine = bufferedReader.readLine();
//            String[] coinsLineArray = coinsLine.split(" ");
//            int[] coins = new int[n];
//            int x = 0;
//            for(int j=0;j<n;j++) {
//                coins[j] =  Integer.valueOf(coinsLineArray[j]);
//                x = x + coins[j];
//            }
//            int y;
//            int maxNumberCoins = 0;
//            int withdraw;
//            for(int k=coins.length;k>0;k--)  {
//                y = coins[k-1];
//                withdraw = 0;
//                while(x>0)  {
//                    if(x > y) {
//                        x = x - y;
//                        withdraw++;
//                    } else if(x==y && y==1){
//                        x = x-y;
//                        withdraw++;
//                    } else {
//                        break;
//                    }
//                }
//                if(withdraw>0)
//                    maxNumberCoins++;
//            }
//            System.out.println(maxNumberCoins);
//        }
//    }
}
