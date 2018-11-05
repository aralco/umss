package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
//https://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
//https://en.wikipedia.org/wiki/Maximum_subarray_problem#CITEREFBrodalJ%C3%B8rgensen2007
//https://youtu.be/86CQq3pKSUw

public class KadanesAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        for(int k=1;k<=t;k++)   {
            int n = Integer.parseInt(bufferedReader.readLine());
            String  input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int[] array = new int[n];
            for(int i=0;i<n;i++)    {
                array[i] = Integer.parseInt(tokenizer.nextToken());
            }
            System.out.println(kadanes2(array));
        }
    }

    //BruteForce
    static int maximumSumSubArray(int[] array)    {
        int totalSum = Integer.MIN_VALUE;
        int partialSum ;
        for(int i=0;i<array.length;i++)    {
            partialSum = 0;
            for(int j=i;j<array.length;j++)    {
                partialSum = partialSum + array[j];
                if(partialSum>totalSum)
                    totalSum = partialSum;
            }
        }
        return totalSum;
    }

    //Kadane's Algorithm
    static int kadanes(int[] array)    {
        int totalSum = array[0];
        int partialSum = array[0];
        for(int i=1;i<array.length;i++)    {
            partialSum = Math.max(array[i], partialSum + array[i]);
            totalSum = Math.max(totalSum, partialSum);
        }
        return totalSum;
    }

    //Kadane's Algorithm keeping track of start and end indez of sub-array
    static int kadanes2(int[] array)    {
        int start = 0;
        int end = 0;
        int totalSum = array[0];
        int partialSum = array[0];
        for(int i=1;i<array.length;i++)    {
            //partialSum = Math.max(array[i], partialSum + array[i]);
            if(array[i]>partialSum + array[i])  {
                if((array[i]>=0 || partialSum>=0))  {
                    start = i;
                    end = i;
                }
                partialSum = array[i];
            } else  {
                partialSum = partialSum + array[i];
                if(array[i]>=0)
                    end = i;
            }
            //totalSum = Math.max(totalSum, partialSum);
            if(partialSum>totalSum) {
                totalSum = partialSum;
            }
        }
        System.out.println("start:"+start+", end:"+end);
        return totalSum;
    }
}
//1 2 3
//3 -4 5 6 1
//-1 -2 -3 -4 5
//-1 -2 -3 -4
//0 4 3 1
//1 0 -2 9 2
//-1 -2 -2 5 0 9
//9 -3 12 2 0 2
//-4 6 -3 -9 3 1 FAIL
