package bo.edu.umss.algorithms.competitions.contest8;

import java.util.Scanner;

//UVA - 116 - D - Unidirectional TSP
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=52

//https://mohamedmosamin.wordpress.com/2012/09/01/uva-116-unidirectional-tsp/
//https://github.com/Agetorp/UVA-solutions/blob/master/116_Unidirectional_TSP.java
//http://www.algorithmist.com/index.php/UVa_116
//https://uva.onlinejudge.org/board/viewtopic.php?t=1114&start=180

public class Main_D_UnidirectionalTSP {

    static int m;
    static int n;
    static int [][] adjacentGraph;
    static int [][] memo;
    static int [][] paths;

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        int min;
        int start;
        int check;
        while(in.hasNext()){
            m = in.nextInt();
            n = in.nextInt();
            adjacentGraph = new int [m][n];
            memo = new int [m][n];
            paths = new int [m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    adjacentGraph[i][j] = in.nextInt();
            }
            min = findPath(0, 0);
            start = 0 ;
            for (int i = 1; i < m; i++) {
                check = findPath(i, 0);
                if(check < min){
                    min = check;
                    start = i;
                }
            }
            for (int i = 0; i < n; i++) {
                out.append(start+1);
                start = paths[start][i];
                if(i < n-1)
                    out.append(" ");
            }
            out.append("\n");
            out.append(min+"\n");
        }
        System.out.print(out);
    }

    static int findPath(int i, int j){
        if(j == n)
            return 0;
        else if(memo[i][j] != 0){
            return memo[i][j];
        }else{
            int down = (i+1) %m;
            int beside = i;
            int up = (i + m -1) %m;
            int localMinimum;
            int index;
            int check;
            localMinimum = findPath(down,j+1);
            index = down;
            check = findPath(beside, j+1);
            if(check < localMinimum || (check == localMinimum && beside < index)){
                localMinimum = check;
                index = beside;
            }
            check = findPath(up, j+1);
            if(check < localMinimum || (check == localMinimum && up < index)){
                localMinimum = check;
                index = up;
            }
            paths[i][j] = index;
            return memo[i][j] = adjacentGraph[i][j] + localMinimum;
        }

    }
}
