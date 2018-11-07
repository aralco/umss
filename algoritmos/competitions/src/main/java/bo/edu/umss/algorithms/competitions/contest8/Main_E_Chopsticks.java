package bo.edu.umss.algorithms.competitions.contest8;

import java.util.Scanner;

//UVA - 10271 - E - Chopsticks
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1212

//https://github.com/zlangley/contest-programming/blob/master/uva/10271.java
//https://f0rth3r3c0rd.wordpress.com/2012/04/29/uva-10271-chopsticks/

public class Main_E_Chopsticks {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int testCases = scanner.nextInt();

            for (int t=0;t<testCases;t++) {
                int k = scanner.nextInt();
                int n = scanner.nextInt();

                int[] chopsticks = new int[n + 1];
                for (int j = 0; j < n; j++)
                    chopsticks[chopsticks.length - j - 1] = scanner.nextInt();

                int[][] m = new int[n + 1][k + 9];
                for (int c = 1; c < m[0].length; c++)
                    for (int r = 0; r < m.length; r++)
                        m[r][c] = Integer.MAX_VALUE;

                for (int c = 1; c < m[0].length; c++) {
                    for (int r = 3*c; r < m.length; r++) {
                        int sqrtBad = chopsticks[r - 1] - chopsticks[r];
                        m[r][c] = Math.min(m[r - 1][c], m[r - 2][c - 1] + sqrtBad*sqrtBad);
                    }
                }
                System.out.println(m[n][k + 8]);
            }
        }
    }