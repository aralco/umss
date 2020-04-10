package bo.edu.umss.algorithms.exams.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Christmas {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++)   {
            int p = scanner.nextInt();
            int h = scanner.nextInt();
            Point[] points = new Point[p];
            for(int i=0;i<p;i++)    {
                points[i] = new Point(scanner.nextInt(), scanner.nextInt());
            }
            compute(points, h);
        }
    }

    static void compute(Point[] points, int h)  {
        List<Point> cornerPoints = convexHull(points, points.length);
        long width = calculateWidth(cornerPoints);
        long height = calculateHeight(h, cornerPoints);
        System.out.println(width+" "+height);
    }

    static long calculateWidth(List<Point> points) {
        double width = 0.0;
        for(int i=0;i<points.size()-1;i++) {
            width = width + points.get(i).distance(points.get(i+1));
        }
        width = width + points.get(points.size()-1).distance(points.get(0));
        return round(width);
    }

    static long calculateHeight(int h, List<Point> points) {
        if(points.size()==3)
            return h;
        else
            return h + round(maxDistanceAmongPoints(points));
    }

    static long round(double n) {
        String number = ""+n+"";
        String[] numbers = number.split("\\.");
        long roundedNumber = Long.parseLong(numbers[0]);
        if(Long.parseLong(numbers[1])>0)
            roundedNumber = roundedNumber+1;
        return roundedNumber;
    }

    static double maxDistanceAmongPoints(List<Point> points)    {
        double maxDistance = 0.0;
        for(int i=0;i<points.size();i++) {
            for(int j=i+1;j<points.size();j++) {
                double distance = points.get(i).distance(points.get(j));
                if(distance>maxDistance)
                    maxDistance=distance;
            }
        }
        return maxDistance;
    }

    static int orientation(Point p, Point q, Point r)   {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0)
            return 0;
        return (val > 0)? 1: 2;
    }

    static List<Point> convexHull(Point points[], int n)    {
        List<Point> hull = new ArrayList<>(n);
        int l = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[l].x)
                l = i;
        }

        int p = l;
        int q;
        do  {
            hull.add(points[p]);
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2)
                    q = i;
            }
            p = q;

        } while (p != l);
        return hull;
    }

    static class Point  {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point p)    {
            return Math.sqrt(Math.pow(p.x-this.x, 2) + Math.pow(p.y-this.y, 2));
        }

    }
}

/*

2
7 10
0 3
2 2
1 1
2 1
3 0
0 0
3 3
3 4
1 100
3 300
200 200
 */