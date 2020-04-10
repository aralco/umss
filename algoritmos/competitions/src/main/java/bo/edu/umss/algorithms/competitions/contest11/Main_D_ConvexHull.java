package bo.edu.umss.algorithms.competitions.contest11;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//UVA - 11626 - Convex Hull
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2673
//https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v116/ConvexHull_UVa11626.java

//https://github.com/lamphanviet/competitive-programming/blob/master/uva-online-judge/accepted-solutions/11626%20-%20Convex%20Hull.cpp
//https://github.com/marioyc/Online-Judge-Solutions/blob/master/UVA/Contest%20Volumes/11626%20-%20Convex%20Hull.cpp
//https://github.com/morris821028/UVa/blob/master/volume116/11626%20-%20Convex%20Hull.cpp
//https://blog.csdn.net/u013480600/article/details/40082763
//http://blog.tobygameac.com/2014/01/11626-convex-hull.html
//http://www.voidcn.com/article/p-gibrpbpd-ud.html
//http://h0rnet.hatenablog.com/entry/2016/02/24/UVA_11626_Convex_Hull_%28_%E5%87%B8%E5%8C%85%E6%A8%A1%E6%9D%BF_%29
//http://alan790712.pixnet.net/blog/post/72085486-%5Buva%5D-11626---convex-hull
//https://algorithmcafe.wordpress.com/2012/08/13/11626-convex-hull/
//https://www.xuebuyuan.com/1474718.html
//https://blog.csdn.net/zxy_snow/article/details/6531875

public class Main_D_ConvexHull {
    static final double EPS = 1e-9;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();

        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++) {
            int n = scanner.nextInt();
            Point[] points = new Point[n];
            for(int i = 0; i < n; i++)
            {
                Point p = new Point(scanner.nextInt(), scanner.nextInt());
                if(scanner.next().charAt(0) == 'Y')
                    points[i] = p;
                else
                {
                    i--; n--;
                }
            }
            points = convexHull(points, n);
            stringBuilder.append(points.length).append("\n");
            for(int i = 0; i<points.length; i++)
                stringBuilder.append(points[i].x).append(" ").append(points[i].y).append("\n");

        }
        System.out.print(stringBuilder);
    }

    static Point[] convexHull(Point[] points, int n)
    {
        Arrays.sort(points, 0, n);
        Point[] ans = new Point[n<<1];
        int start = 0, size = 0;
        for(int i = 0; i < n; i++)
        {
            Point p = points[i];
            while(size - start >= 2 && !compute(ans[size-2], ans[size-1], p)) size--;
            ans[size++] = p;
        }

        start = --size;
        for(int i = n - 1; i >= 0; i--)
        {
            Point p = points[i];
            while(size - start >= 2 && !compute(ans[size-2], ans[size-1], p)) size--;
            ans[size++] = p;
        }
        return Arrays.copyOf(ans, size - 1);
    }

    static class Point implements Comparable<Point>
    {
        int x, y;

        Point(int a, int b) { x = a; y = b; }

        public int compareTo(Point p)
        {
            if(x != p.x) return x - p.x;
            return y - p.y;
        }
    }

    static class Vector
    {
        double x, y;

        Vector(Point a, Point b)
        {
            x = b.x - a.x;
            y = b.y - a.y;
        }

        double cross(Vector v)
        {
            return x * v.y - y * v.x;
        }
    }

    static boolean compute(Point a, Point b, Point c)
    {
        return new Vector(a, b).cross(new Vector(a, c)) + EPS >= 0;
    }
}
