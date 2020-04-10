package bo.edu.umss.algorithms.exams.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NavidadLaboriosa {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        for(int t=1;t<=testCases;t++)   {
            String nk = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(nk);
            int n = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());
            int[] capacities = new int[n];
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int totalWeight=0;
            for(int i=0;i<n;i++)    {
                capacities[i] = Integer.parseInt(tokenizer.nextToken());
                totalWeight = totalWeight + capacities[i];
            }
            List<LinkedList<Integer>> result = assignCapacities(capacities, n, k, totalWeight);
            System.out.println("Caso "+t+":");
            for(LinkedList<Integer> l:result)    {
                for(int c:l)    {
                    System.out.print(c+" ");
                }
                System.out.println("");
            }
        }
    }

    static List<LinkedList<Integer>> assignCapacities(int[] capacities, int n, int duendes, long totalWeight)  {
        long averageWeight = totalWeight/duendes;
        List<LinkedList<Integer>> result = new ArrayList<>(duendes);
        int lastIndex=0;
        for(int k=0;k<duendes;k++)  {
            result.add(new LinkedList<>());
            int maxCapacityPerDuende = 0;
            for(int i=lastIndex;i<capacities.length;i++) {
                if(maxCapacityPerDuende+capacities[i]<=averageWeight) {
                    maxCapacityPerDuende = maxCapacityPerDuende + capacities[i];
                    result.get(k).add(capacities[i]);
                    lastIndex = i+1;
                }
            }
            if(k==duendes-1 && lastIndex<capacities.length) {
                while(lastIndex<capacities.length)  {
                    maxCapacityPerDuende = maxCapacityPerDuende + capacities[lastIndex];
                    result.get(k).add(capacities[lastIndex]);
                    lastIndex++;
                }
            }
        }
        return result;
    }
}

/*
3
6 2
3 1 1 2 2 1
9 3
100 200 300 400 500 600 700 800 900
9 2
1 3 1 2 1 1 2 2 4
*/