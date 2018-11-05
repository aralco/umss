package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.util.Scanner;

//https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
public class Greedy_MinNumberOfCoins {
    int[] indianCurrency = new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000};
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        Greedy_MinNumberOfCoins coins = new Greedy_MinNumberOfCoins();
        System.out.println(coins.findMinNumberOfCoins(v));
    }

    int findMinNumberOfCoins(int v)  {
        //int[] numberOfCoinsRequired = new int[9];
        int numberOfCoinsRequired = 0;
        for(int i=indianCurrency.length-1;i>=0;i--)   {
            while(v>=indianCurrency[i])    {
                v = v - indianCurrency[i];
//                numberOfCoinsRequired[i] = numberOfCoinsRequired[i]+1;
                numberOfCoinsRequired++;
            }
            if(v==0)
                break;
        }
        return numberOfCoinsRequired;
    }
}
