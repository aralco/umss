package bo.edu.umss.algorithms.exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumeroInfinito {
    //Better Solution
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i;

        for(int j=0;j<t;j++)    {
            i = Integer.parseInt(br.readLine());
            System.out.println(findNthInSequence(i));
        }
    }
    static int findNthInSequence(int n)    {
        int[] digits = new int[10];
        int pointer=-1;
        int i=0;
        while(i<=n)   {
            for(int k=1;k<=n;k++)    {
                for(int z=1;z<=k;z++)   {
                }
            }
        }
        return i;
    }

    //Naive Solution
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        int i;
//
//        String seq = generateSequence(500);
//        for(int j=0;j<t;j++)    {
//            i = Integer.parseInt(br.readLine());
//            System.out.println(seq.substring(i-1,i));
//        }
//    }
//    static String generateSequence(int k)    {
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i=1;i<=k;i++)    {
//            for(int j=1;j<=i;j++)   {
//                stringBuilder.append(j);
//            }
//        }
//        return stringBuilder.toString();
//    }

}
