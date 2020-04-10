package bo.edu.umss.algorithms.competitions.contest11;

//UVA - 10589 - Area
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1530
//https://www.udebug.com/UVa/10589
//https://tutorial92.wordpress.com/2012/08/18/uva-10589-area-tutorial/
//Point p1 is in the striped area if it has distance <= a with all the coordinates of the square
//https://github.com/shailesh1001/uva-2/blob/master/UVa10589_Area.java
//https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v110/Area_UVa10589.java
//http://ringsacm.pixnet.net/blog/post/6544662-acm-10589%3A-area
//https://xoptutorials.com/index.php/2017/02/15/uva10589/
//http://www.voidcn.com/article/p-pyzwznge-ud.html
//https://blog.csdn.net/mobius_strip/article/details/8349317
//https://github.com/morris821028/UVa/blob/master/volume105/10589%20-%20Area.cpp
//https://github.com/yulonglong/UVa-Solutions/blob/master/10589.cpp
//https://github.com/marioyc/Online-Judge-Solutions/blob/master/UVA/Contest%20Volumes/10589%20-%20Area.cpp
//http://codealltheproblems.blogspot.com/2015/08/uva-10589-area.html
//http://theinfinitytutorial.blogspot.com/2013/09/uva-10589-area.html

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_E_Area {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String input = bufferedReader.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input);
            int n = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            if(n==0)
                break;
            double[][] points = new double[n][2];
            for(int i=0;i<n;i++)    {
                input = bufferedReader.readLine();
                tokenizer = new StringTokenizer(input);
                points[i][0] = Double.parseDouble(tokenizer.nextToken());
                points[i][1] = Double.parseDouble(tokenizer.nextToken());
            }

            calculateStripedRegionArea(a, n, points);
        }
    }

    static void calculateStripedRegionArea(int a, int n, double[][] points)    {
        int m = 0;
        for(int i=0;i<points.length;i++)    {
            if(pointBelongsToArea(a, points[i][0], points[i][1]))
                m++;
        }
        System.out.printf("%.5f%n", (double)m*a*a/n);
    }

    static boolean pointBelongsToArea(int a, double x, double y)    {
        return distance(0,0, x, y)<=a && distance(a, 0, x, y)<=a && distance(a, a, x, y)<=a && distance(0,a, x, y)<=a;
    }

    static double distance(int x0, int y0, double x, double y)    {
        return Math.sqrt(Math.pow(x-x0, 2) + Math.pow(y-y0, 2));
    }
}
