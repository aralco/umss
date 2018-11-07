package bo.edu.umss.algorithms.competitions.contest8;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

//UVA - 10069 - A - Distinct Subsequences
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1010

//https://codingnerd.wordpress.com/2016/02/12/uva-10069-solution/
//https://github.com/Diusrex/UVA-Solutions/blob/master/10069%20Distinct%20Subsequences.java
//https://github.com/shahidul2k9/problem-solution/blob/master/uva%20online%20judge/10069%20-%20Distinct%20Subsequences.java
//https://f0rth3r3c0rd.wordpress.com/2011/11/10/uva-10069-distinct-subsequences/
//http://mypaper.pchome.com.tw/zerojudge/post/1323236787
//https://mohamedmosamin.wordpress.com/2012/10/30/uva-10069-distinct-subsequences/
//http://www.voidcn.com/article/p-gogkbrzs-xk.html
//http://www.voidcn.com/article/p-zfdjzhhy-mr.html
//http://codealltheproblems.blogspot.com/2015/06/uva-10069-distinct-subsequences.html
//http://compscijporcelli.blogspot.com/2015/02/distinct-subsequences-problem-10069-uva.html
//http://jeno5980515.github.io/2015/03/25/Online%20Judge/UVa/10069%20-%20Distinct%20Subsequences/

public class Main_A_DistinctSubsequences {
    static String sequence, subSequence;
    static BigInteger distSubSeq[][];
    static int k, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out, true);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int t=1;t<=testCases;t++) {
            sequence = scanner.nextLine();
            subSequence = scanner.nextLine();
            m = sequence.length();
            k = subSequence.length();
            distSubSeq = new BigInteger[k + 1][m + 1];
            writer.println(distinctSubSequence(0, 0));
        }
    }

    static BigInteger distinctSubSequence(int i, int j) {
        if (distSubSeq[i][j] != null) {
            return distSubSeq[i][j];
        }
        BigInteger result;
        if (i == k) {
            result = BigInteger.ONE;
        } else if (j == m) {
            result = BigInteger.ZERO;
        } else {
            result = distinctSubSequence(i, j + 1);
            if (subSequence.charAt(i) == sequence.charAt(j)) {
                result = result.add(distinctSubSequence(i + 1, j + 1));
            }
        }
        distSubSeq[i][j] = result;
        return result;
    }
}
