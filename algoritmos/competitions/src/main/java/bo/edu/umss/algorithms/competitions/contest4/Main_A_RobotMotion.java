package bo.edu.umss.algorithms.competitions.contest4;

import java.util.Scanner;

//https://github.com/PuzzlesLab/UVA/blob/master/King/10116%20Robot%20Motion.java
//https://github.com/izharishaksa/UVa-Solution/blob/master/src/graph/traversal/Problem10116YES.java
//https://gocodergo.wordpress.com/2017/05/25/uva-10116-robot-motion/

public class Main_A_RobotMotion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        int n;
        int m;
        int in;
        int out;

        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            in = scanner.nextInt();
            out = 0;
            if (n==0&&m==0&&in==0) {
                break;
            }
            scanner.nextLine();
            char[][] map = new char[n][m];
            int[][] visited = new int[n][m];
            int[][] path = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = scanner.nextLine();
                for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            in--;
            int steps = 1;
            visited[out][in] = 1;
            path[out][in] = 1;
            while (true) {
                switch (map[out][in]) {
                    case 'W':
                        in--;
                        break;
                    case 'E':
                        in++;
                        break;
                    case 'N':
                        out--;
                        break;
                    default:
                        out++;
                        break;
                }
                if (out < 0 || out >= n || in < 0 || in >= m) {
                    System.out.println(steps + " step(s) to exit");
                    break;
                }
                if (visited[out][in]==1) {
                    System.out.println((path[out][in] - 1) + " step(s) before a loop of " + (steps - path[out][in] + 1) + " step(s)");
                    break;
                }
                steps++;
                visited[out][in] = 1;
                path[out][in] = steps;
            }
        }
    }
}
