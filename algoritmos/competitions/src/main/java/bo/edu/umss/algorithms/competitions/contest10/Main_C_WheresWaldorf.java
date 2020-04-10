package bo.edu.umss.algorithms.competitions.contest10;

import java.util.Scanner;

//UVA - 10010 - Where's Waldorf?
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=951

//http://www.algorithmist.com/index.php/UVa_10010
//https://github.com/izharishaksa/UVa-Solution/blob/master/src/stringprocessing/adhoc/Problem10010YES.java

public class Main_C_WheresWaldorf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[][] startingPosition = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        for (int t = 0; t < testCases; t++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            char[][] map = new char[row][col];
            for (int i = 0; i < row; i++) {
                map[i] = sc.next().toCharArray();
            }
            int q = sc.nextInt();
            for (int i = 0; i < q; i++) {
                String s = sc.next();
                boolean found = false;
                for (int j = 0; j < row && !found; j++) {
                    for (int k = 0; k < col && !found; k++) {
                        StringBuilder[] sb = new StringBuilder[8];
                        for (int l = 0; l < 8; l++) {
                            sb[l] = new StringBuilder();
                        }
                        for (int l = 0; l < s.length(); l++) {
                            for (int ll = 0; ll < 8; ll++) {
                                try {
                                    sb[ll].append(map[j + (l * startingPosition[ll][0])][k + (l * startingPosition[ll][1])]);
                                } catch (Exception e) {
                                }
                            }
                        }
                        for (int l = 0; l < 8; l++) {
                            if (sb[l] != null && sb[l].toString().toLowerCase().equals(s.toLowerCase())) {
                                System.out.println((j + 1) + " " + (k + 1));
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (t < testCases - 1) {
                System.out.println();
            }
        }
    }
}