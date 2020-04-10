package bo.edu.umss.algorithms.competitions.contest10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//UVA - 164 - String Computer
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=100

//https://repl.it/@SElayyan/UVA-164-String-Computer
//https://uva.onlinejudge.org/board/viewtopic.php?t=545&start=90
//http://blog.tobygameac.com/2013/08/uva-164-string-computer.html
//https://github.com/morris821028/UVa/blob/master/volume001/164%20-%20String%20Computer.cpp
//https://github.com/ajahuang/UVa/blob/master/UVa%20164%20-%20String%20Computer.cpp
//https://www.cnblogs.com/scau20110726/archive/2013/02/25/2932155.html
//http://www.voidcn.com/article/p-xkyobeou-ud.html
//http://onlinejudgesolution.blogspot.com/2017/04/uva-solution-164-string-computer.html
//http://shoaibeee05.blogspot.com/2015/06/uva-164-solution-string-computer.html
//https://github.com/miciek/problem-hunting/blob/master/java/src/com/michalplachta/hunting/uva/s164/Main.java

public class Main_D_StringComputer {
    static Integer[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=bufferedReader.readLine())!="#")    {
            StringTokenizer tokenizer = new StringTokenizer(input);
            String initialState = tokenizer.nextToken();
            String finalState = tokenizer.nextToken();
            if((initialState==null || initialState.equals("\\32"))|| (finalState==null || finalState.equals("\\32")))
                System.out.println("E");
            minchangesToInstruction(initialState, finalState);
        }
    }

    static void minchangesToInstruction(String initialState, String finalState) {
        memo = new Integer[22][22];
        int n = initialState.length();
        int m= finalState.length();
        calc(initialState, finalState, 0, 0, n, m);
        solve(initialState, finalState, 0, 0, 0, n, m);
        System.out.println("E");
    }

    static int calc(String a, String b, int i , int j, int n, int m){
        if(j == m)
            return n - i;
        if(i == n)
            return m - j;
        if(memo[i][j] != null)
            return memo[i][j];
        if(a.charAt(i)==b.charAt(j))
            memo[i][j] = calc(a, b, i + 1 , j + 1, n, m);
        else
            memo[i][j] = 1 + Math.min(calc(a, b, i + 1 , j, n, m) , Math.min(calc(a, b, i + 1 , j + 1, n, m), calc(a, b, i , j + 1, n, m)));
        return memo[i][j];
    }

    static void solve(String a, String b, int i , int j , int di, int n, int m) {
        if (i == n) {
            int y = m - j;
            for (int x = y; x > 0; x--) {
                System.out.print("I" + b.charAt(j) + (di + 1 < 10 ? "0" : "") + (di + 1));
                di++;
                j++;
            }
            return;
        }
        if (j == m) {
            int y = n - i;
            for (int x = y; x > 0; x--) {
                System.out.print("D" + a.charAt(i) + (di + 1 < 10 ? "0" : "") + (di + 1));
                i++;
            }
            return;
        }
        if (a.charAt(i) == b.charAt(j)) {
            solve(a, b, i + 1, j + 1, di + 1, n, m);
            return;
        }
        if (memo[i][j] == calc(a, b, i + 1, j, n, m) + 1) {
            System.out.print("D" + a.charAt(i) + (di + 1 < 10 ? "0" : "") + (di + 1));
            solve(a, b, i + 1, j, di, n, m);
            return;
        }
        if (memo[i][j] == calc(a, b, i + 1, j + 1, n, m) + 1) {
            System.out.print("C" + b.charAt(j) + (di + 1 < 10 ? "0" : "") + (di + 1));
            solve(a, b, i + 1, j + 1, di + 1, n, m);
            return;
        }
        if (memo[i][j] == calc(a, b, i, j + 1, n, m) + 1) {
            System.out.print("I" + b.charAt(j) + (di + 1 < 10 ? "0" : "") + (di + 1));
            solve(a, b, i, j + 1, di + 1, n, m);
            return;
        }
    }

}
