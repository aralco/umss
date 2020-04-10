package bo.edu.umss.algorithms.competitions.contest11;

import java.util.*;

//UVA - 681 - Convex Hull Finding
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=622

//http://mypaper.pchome.com.tw/zerojudge/post/1322633823
//http://www.voidcn.com/article/p-tpargnbv-bex.html
//http://h0rnet.hatenablog.com/entry/2016/02/24/UVA_681_Convex_Hull_Finding_%28_%E5%87%B8%E5%8C%85%E6%A8%A1%E6%9D%BF_%29
//https://blog.csdn.net/mobius_strip/article/details/8350063
//http://nminhtu94.blogspot.com/2013/06/uva-681-convex-hull-finding.html
//https://github.com/ackoroa/UVa-Solutions/blob/master/UVa%20681%20-%20Convex%20Hull%20Finding/src/UVa%20681%20-%20Convex%20Hull%20Finding.cpp
//https://github.com/Diusrex/UVA-Solutions/blob/master/681%20Convex%20Hull%20Finding.cpp
//https://github.com/morris821028/UVa/blob/master/volume006/681%20-%20Convex%20Hull%20Finding.cpp
//https://github.com/izharishaksa/UVa-Solution/blob/master/src/geometry/convexhull/Problem681.java
public class Main_C_ConvexHullFinding {
    public static void main(String[] args) {
        boolean[] prime = new boolean[100001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        for (int i = 0; i < 100000; i++) {
            if (prime[i]) {
                for (int j = i + i; j < 100000; j += i) {
                    prime[j] = false;
                }
            }
        }
        for (int i = 99999; i >= 2; i--) {
            if (prime[i]) {
                System.out.println(i);
                break;
            }
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            Point[] point = new Point[n];
            int ind = 0;
            int a = sc.nextInt(), b = sc.nextInt();
            point[0] = new Point(a, b);
            for (int i = 1; i < n; i++) {
                a = sc.nextInt();
                b = sc.nextInt();
                if (point[i].y < point[ind].y || (point[i].y == point[ind].y && point[i].x > point[ind].x)) {
                    ind = i;
                }
            }

            Point temp = point[0];
            point[0] = point[ind];
            point[ind] = temp;

            Point pivot = point[0];
            for (int i = 0; i < n; i++) {
                point[i].setPivot(pivot);
            }

            Arrays.sort(point);

            Stack<Point> st = new Stack<Point>();
            Point prev, cur;
            st.push(point[n - 1]);
            st.push(point[0]);

            ind = 1;
            while (ind < n) {

            }
        }
    }

    //Compare based on it's angle w.r.t. point called pivot.
    static class Point implements Comparable<Point> {

        public int x;
        public int y;
        private Point pivot;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setPivot(Point pivot) {
            this.pivot = pivot;
        }

        private int area(Point a, Point b) {
            return pivot.x * a.y - pivot.y * a.x + a.x * b.y - a.y * b.x + b.x * pivot.y - b.y * pivot.x;
        }

        private int dist(Point a, Point b) {
            int dx = a.x - b.x;
            int dy = a.y - b.y;

            return dx * dx + dy * dy;
        }

        @Override
        public int compareTo(Point o) {
            if (area(this, o) == 0) {
                if (dist(pivot, this) < dist(pivot, o)) {
                    return - 1;
                }
                return 1;
            }
            int d1x = this.x - pivot.x;
            int d1y = this.y - pivot.y;
            int d2x = o.x - pivot.x;
            int d2y = o.y - pivot.y;

            if (Math.atan2((double) d1y, (double) d1x) - Math.atan2((double) d2y, (double) d2x) < 0) {
                return -1;
            }
            return 1;
        }
    }
}
