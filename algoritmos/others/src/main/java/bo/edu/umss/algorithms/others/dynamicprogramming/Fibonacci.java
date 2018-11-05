package bo.edu.umss.algorithms.others.dynamicprogramming;

public class Fibonacci {
    public static void main(String[] args)  {
        final long start = System.nanoTime();
        System.out.println(fibonacci1(43));
        final long end = System.nanoTime();
        System.out.println("ETA: "+(double)(end-start)/1000 +" ms");
    }

    //naive solution #1 using Fibonacci recursive definition 0 1 1 2 ... 433494437 ETA: 2666817.834 ms
    static int fibonacci1(int n)    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci1(n-1) + fibonacci1(n-2);
    }

    // solution #2 using Fibonacci non recursive definition 0 1 1 2 ... 433494437 ETA: 211.896 ms
    static int fibonacci2(int n)    {
        if(n==0)
            return 0;
        int[] fib = new int [n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2;i<=n;i++)   {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }
}
//https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
//https://www.geeksforgeeks.org/large-fibonacci-numbers-java/
//http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibtable.html