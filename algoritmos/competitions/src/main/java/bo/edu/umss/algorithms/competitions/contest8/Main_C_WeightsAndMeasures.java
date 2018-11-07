package bo.edu.umss.algorithms.competitions.contest8;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

//UVA - 10154 - C - Weights and Measures
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1095

//https://github.com/nbrenwald/UVa/blob/master/10154-Weights_and_Measures.java
//https://uva.onlinejudge.org/board/viewtopic.php?t=2882&start=15
//http://code.antonio081014.com/2012/02/uva10154weightsandmeasuresjava.html
public class Main_C_WeightsAndMeasures {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Turtle> turtles = new ArrayList<>();
        while (scanner.hasNextInt()) {
            Turtle turtle = new Turtle();
            turtle.weight = scanner.nextInt();
            turtle.strength = scanner.nextInt();
            turtle.r = turtle.strength - turtle.weight;
            turtles.add(turtle);
        }
        Collections.sort(turtles);
        Turtle[] a = new Turtle[turtles.size()];
        turtles.toArray(a);
        System.out.println(max(a));
    }

    static int max(Turtle[] a) {

        int[] prev = new int[a.length+1];
        int[] memo = new int[a.length+1];


        for (int i = 0; i< prev.length; i++) {
            prev[i] = Integer.MAX_VALUE;
        }

        prev[1] = a[0].weight;
        memo[0]= Integer.MAX_VALUE;
        int max = 1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < memo.length; j++){
                int notUse =  prev[j];
                int use = (a[i].r >= prev[j-1]) ? prev[j-1] + a[i].weight : Integer.MAX_VALUE;
                memo[j] = Math.min (use, notUse);
                if (memo[j] != Integer.MAX_VALUE){
                    max = Math.max(max, j);
                }
            }
            int[] tmp = prev;
            prev = memo;
            memo = tmp;
        }
        return max;
    }

    static class Turtle implements Comparable<Turtle> {
        private int weight;
        private int strength;
        private int r;

        @Override
        public int compareTo(Turtle t) {
            if (strength < t.strength) return -1;
            if (strength > t.strength) return 1;
            else return 0;
        }
    }

}