package bo.edu.umss.algorithms.competitions.contest7;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//UVA - 10603 - D - Fill
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1544
//https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v106/Fill_UVa10603.java
//https://f0rth3r3c0rd.wordpress.com/2011/08/29/uva-10603-fill/
//http://andrew-algorithm.blogspot.com/2014/12/uva-problem-10603-fill.html
//https://github.com/morris821028/UVa/blob/master/volume106/10603%20-%20Fill.cpp
//https://github.com/lamphanviet/competitive-programming/blob/master/uva-online-judge/accepted-solutions/10603%20-%20Fill.cpp
//http://morris821028.github.io/2014/05/05/oj/uva/uva-10603/
//http://www.voidcn.com/article/p-ukcvnmus-gw.html
//https://www.programering.com/a/MjM0ADNwATI.html

public class Main_D_Fill {

    static int a,b,c,d;
    static final int INF = Integer.MAX_VALUE;
    static int[] maxSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            d = scanner.nextInt();

            maxSize =  new int[]{a,b,c};
            int min = dijkstra();
            System.out.println(min+" "+d);
        }
    }

    static int pour(int[] jugs, int from, int into) {
        int prev = jugs[into];
        jugs[into] = jugs[from] + jugs[into];
        jugs[from] = 0;
        if(jugs[into]>maxSize[into])    {
            jugs[from] = jugs[into] - maxSize[into];
            jugs[into] = maxSize[into];
        }
        return jugs[into] - prev;
    }

    static int dijkstra()   {
        int[] min = new int[201];
        Arrays.fill(min, INF);

        int[][] dist = new int[a+1][b+1];
        for(int i = 0; i <= a; i++)
            Arrays.fill(dist[i], INF);
        dist[0][0] = 0;
        min[c] = min[0] = 0;
        PriorityQueue<Triple> q = new PriorityQueue<>();
        q.add(new Triple(0,0,0));
        while(!q.isEmpty()) {
            Triple cur = q.remove();
            if(cur.cost > dist[cur.i][cur.j])
                continue;
            for(int i = 0; i < 3; i++)  {
                for(int j = 0; j < 3; j++)  {
                    if(i!=j)    {
                        int[] jugs = new int[]{cur.i,cur.j, c - cur.i - cur.j};
                        int totalCost = cur.cost + pour(jugs,i,j);
                        if(totalCost < dist[jugs[0]][jugs[1]])  {
                            dist[jugs[0]][jugs[1]] = totalCost;

                            min[jugs[0]] = Math.min(min[jugs[0]],totalCost);
                            min[jugs[1]] = Math.min(min[jugs[1]],totalCost);
                            min[jugs[2]] = Math.min(min[jugs[2]],totalCost);

                            q.add(new Triple(jugs[0],jugs[1],totalCost));
                        }
                    }
                }
            }
        }
        while(min[d]==INF)
            d--;
        return min[d];
    }

    static class Triple implements Comparable<Triple>   {
        int i,j,cost;
        Triple(int x, int y, int z) {i = x; j = y; cost = z;}
        public int compareTo(Triple t) {return this.cost - t.cost;}
    }
}

//public class Main_D_Fill {
//    public static void main(String[] args)  {
//        Scanner scanner = new Scanner(System.in);
//        int testCases = scanner.nextInt();
//        for(int t=1;t<=testCases;t++)   {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            int c = scanner.nextInt();
//            int d = scanner.nextInt();
//            int waterProduced = 0;
//            boolean flag = true;
//            while(flag) {
//                //pour water from c to a
//                if(a <= c)    {
//                    a = c - a;
//                    c = c - a;
//                    waterProduced = waterProduced + a;
//                    //pour water from c to a
//                } else if(b <= c)   {
//                    b = b - c;
//                    waterProduced = waterProduced + b;
//                    //pour water from c to a
//                } else if(c <= a)   {
//                    c = a - c;
//                    waterProduced = waterProduced + c;
//                    //pour water from c to a
//                } else if(b <= a) {
//                    b = a - b;
//                    waterProduced = waterProduced + b;
//                    //pour water from c to a
//                } else if(c <= b)   {
//                    c = b - c;
//                    waterProduced = waterProduced + c;
//                    //pour water from c to a
//                } else if(a <= b)   {
//                    a = b - a;
//                    waterProduced = waterProduced + a;
//                }
//                if(d==a || d==b || d==c)    {
//                    flag=false;
//                    System.out.println(waterProduced+" "+d);
//                }else   {
//                    //flag=false;
//                    System.out.println("====="+waterProduced);
//                }
//            }
//        }
//    }
//}
