package bo.edu.umss.algorithms.competitions.contest5;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

//UVA 12485 - Perfect Choir
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=3929
//https://github.com/dulljester/UVa-Online-Judge-Solutions/blob/master/Main12485.java
public class Main_D_PerfectChoir {

    public static void main(String... args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scan = new Scanner(System.in);
        int n;

        long total,T;
        int[] c = new int[10100];

        int i,j,k,low,high,mid;
        long rounds;
        for ( ;scan.hasNext(); ) {
            c = new int[n = scan.nextInt()];
            for ( total = 0, i = 0; i < n; ++i )
                total += (c[i] = scan.nextInt());
            if ( 0 != (total%n) ) {
                bw.write("-1\n");
                continue ;
            }
            T = total/n;
            Arrays.sort(c);
            if ( c[n-1] == T ) {
                bw.write("1\n");
                continue ;
            }
            for ( low = 0, high = n-1; low+1<high; ) {
                mid = (low+high)/2;
                if ( c[mid] > T )
                    high = mid;
                else low = mid;
            }
            for ( rounds = 0, k = high; k < n; ++k )
                rounds += c[k]-T;
            bw.write(++rounds+"\n");
        }
        bw.flush();

    }
}
