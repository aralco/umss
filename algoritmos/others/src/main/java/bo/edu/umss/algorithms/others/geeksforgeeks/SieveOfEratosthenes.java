package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.util.Scanner;

public class SieveOfEratosthenes {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        for(int i=0;i<t;i++)    {
            n = scanner.nextInt();
            final long start = System.nanoTime();
            //            findPrimeNumbersLessThanOrEqualToNSieveOfEratosthenes(n);
            sieveOfEratosthenes(n);
            final long end = System.nanoTime();
            System.out.println("");
            System.out.println("ETA: "+(double)(end-start)/1000 +" ms");
        }
    }
    static void findPrimeNumbersLessThanOrEqualToNSieveOfEratosthenes(int n)    {
        int[] baseList = new int[n-1];
        int number=2;
        for(int i=0;i<baseList.length;i++)    {
            baseList[i]=number;
            number++;
        }
        for(int p=2;p*p<=n;p++) {
            for(int k=2;k*p<=n;k++)    {
                for(int i=0;i<baseList.length;i++)  {
                    if(baseList[i] == p*k)  {
                        baseList[i]=0;
                    }
                }
            }
        }
        for(int i=0;i<baseList.length;i++)  {
            if(baseList[i]!=0)
                System.out.print(baseList[i]+" ");
        }
        System.out.println("");
    }

    static void sieveOfEratosthenes(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*2; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for(int i = 2; i <= n; i++)
        {
            if(prime[i] == true)
                System.out.print(i + " ");
        }
    }

}
