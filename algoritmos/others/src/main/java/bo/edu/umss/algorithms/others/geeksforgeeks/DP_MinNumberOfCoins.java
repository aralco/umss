package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/number-of-coins/0
public class DP_MinNumberOfCoins {
    int[] coins;
    public DP_MinNumberOfCoins(int[] coins) {
        this.coins = coins;
    }


    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int k=1;k<=t;k++)   {
            int v = scanner.nextInt();
            int n = scanner.nextInt();
            int[] coins = new int[n];
            for(int i=0;i<n;i++)    {
                coins[i] = scanner.nextInt();
            }
            Arrays.sort(coins);
            DP_MinNumberOfCoins minCoins = new DP_MinNumberOfCoins(coins);
            System.out.println(minCoins.findMinNumberOfCoins(v));
        }
    }

    int findMinNumberOfCoins(int v)  {
        int res = 0;
        if(v==0)
            return 0;
        for(int coin:coins) {
            if(v>=coin) {
                int subRes = findMinNumberOfCoins(v - coin);
                if(subRes !=res && subRes+1<res)
                    res =subRes+1;
            }
        }
        return res;
    }
}
