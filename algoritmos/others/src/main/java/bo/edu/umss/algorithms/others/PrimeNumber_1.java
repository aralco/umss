package bo.edu.umss.algorithms.others;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber_1 {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
                101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199
        };
//        for(int n:primes)   {
//            System.out.println(isPrime(n)?n+" is Prime.":n+" is not Prime.");
//        }
        final long start = System.nanoTime();
//        for(int i=1;i<=2000000;i++)  {
//            System.out.println(isPrime(i)?i+" is Prime.":i+" is not Prime.");
//        }

        //print 10 first primes
//        findNPrimeNumbers(30);

        System.out.println("****************************************");

        //find prime numbers less than or equal to n
//        findPrimeNumbersLessThanOrEqualToN(300000);

        //find prime numbers less than or equal to n
//        findPrimeNumbersLessThanOrEqualToNSieveOfEratosthenes(300000);

        sieveOfEratosthenes(2000000);

        final long end = System.nanoTime();
        System.out.println("ETA: "+(double)(end-start)/1000 +" ms");
    }

    static void sieveOfEratosthenes(int n)  {
        boolean[] baseList = new boolean[n];
        for(int i=0;i<baseList.length;i++)   {
            baseList[i]=true;
        }

        for(int i=2;i<Math.sqrt(n);i++) {
            if(baseList[i]) {
                for(int j=i*i;j<n;j=j+i)  {
                    baseList[j]=false;
                }
            }
        }
        for(int k=2;k<baseList.length;k++)  {
            if(baseList[k])
                System.out.print(k+" ");
        }
        System.out.println("");
    }


    static void findPrimeNumbersLessThanOrEqualToNSieveOfEratosthenes(int n)    {
        int[] baseList = new int[n+1];
        int number=2;
        for(int i=0;i<baseList.length;i++)    {
            baseList[i]=number;
            number++;
        }
        int pivot = 0;
        System.out.println(Arrays.toString(baseList));
        int p=2;
        while(p*p<=n) {
            System.out.println("p="+p);
            for(int k=2;k*p<=n;k++)    {
                for(int i=pivot;i<baseList.length;i++)  {
                    if(baseList[i] == p*k)  {
                        baseList[i]=0;
                    }
                }
//                System.out.println(Arrays.toString(baseList));
            }
            pivot++;
            p = baseList[pivot];

            while(p==0 && pivot<baseList.length-1) {
                pivot++;
                p = baseList[pivot];
            }
        }
        System.out.println(Arrays.toString(baseList));

    }

    static void findPrimeNumbersLessThanOrEqualToN(int n)  {
        for(int i=1;i<=n;i++)   {
            if(isPrime(i))  {
                System.out.println(i);
            }
        }
    }

    static void findNPrimeNumbers(int n) {
        int primeNumbersCounter=0;
        int i=1;
        while(primeNumbersCounter<n) {
            if(isPrime(i))  {
                System.out.println(i);
                primeNumbersCounter++;
            }
            i++;
        }
    }

    static boolean isPrime(int n)   {
        boolean isPrime = true;
        if(n<2)
            isPrime = false;
        else    {
            for(int i=n-1;i>=2;i--)  {
                if(n%i==0)  {
                    isPrime = !isPrime;
                    break;
                }
            }
        }
        return isPrime;
    }
}
