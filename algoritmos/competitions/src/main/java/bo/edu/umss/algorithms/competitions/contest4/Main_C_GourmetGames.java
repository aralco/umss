package bo.edu.umss.algorithms.competitions.contest4;

import java.util.Scanner;

public class Main_C_GourmetGames {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++)    {
            getNumberOfShowsRequired(scanner.nextInt(), scanner.nextInt());
        }
    }

    static void getNumberOfShowsRequired(int n, int m)  {
        int showsNumber = 0;
        while(n-m+1>=m)  {
            showsNumber++;
            n=n-m+1;
        }
        if(n==m)    {
            System.out.println(++showsNumber);
        } else  {
            System.out.println("cannot do this");
        }
    }
}
