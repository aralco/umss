package bo.edu.umss.algorithms.others.coursera;

public class Multiply2NDigitNumbers {

    public static void main(String[] args)  {
        int a = 5678;
        int b = 1234;

        System.out.println(multiply(a, b));
    }

    //Naive solution
    static int multiply(int a, int b)    {
        return a*b;
    }

    //Classic multiplication algorithm
    static int classicMultiply(int a, int b)    {
        return a*b;
    }

    //Karatsuba multiplication algorithm
    static int karatsubaMultiply(int a, int b)    {
        return a*b;
    }
}
