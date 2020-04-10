package bo.edu.umss.algorithms.competitions.contest10;

import java.util.Scanner;

//UVA - 10739 - String to Palindrome
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1680

//http://www.algorithmist.com/index.php/UVa_10739
//https://ageneidy.wordpress.com/2014/07/14/uva-10739-string-to-palindrome/
//https://algorithmcafe.wordpress.com/2012/11/18/10739-string-to-palindrome/
//https://yq.aliyun.com/wenji/101574

public class Main_E_StringToPalindrome {
    static Integer memo[][];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String word = scanner.next();
            System.out.println("Case "+t+": "+minChangestoPalindrome(word));
        }
    }

    static int minChangestoPalindrome(String word)  {
        memo = new Integer[word.length()][word.length()];
        return minChangestoPalindrome(word, 0, word.length()-1);
    }

    static int minChangestoPalindrome(String word, int i, int j)  {
        if(memo[i][j]!=null)
            return memo[i][j];
        if((j+1)-i<2)
            return 0;
        else if(word.charAt(i)==word.charAt(j))
            return minChangestoPalindrome(word, i+1, j-1);
        return memo[i][j] = 1 + Math.min(minChangestoPalindrome(word, i + 1, j),
                    Math.min(minChangestoPalindrome(word, i, j - 1), minChangestoPalindrome(word, i + 1, j - 1)));

    }

}

/*
tanbirahmed
shahriarmanzoor
monirulhasan
syedmonowarhossain
sadrulhabibchowdhury
mohammadsajjadhossain

*/