package bo.edu.umss.algorithms.competitions.contest4;

import java.util.Scanner;

public class Main_E_BilliardBounces {
//https://github.com/andrewphamvk/UVa/blob/master/11130%20-%20Billiard%20bounces/Main.java
// https://uva.onlinejudge.org/board/viewtopic.php?t=50861
//https://ideone.com/2rmUXu
//https://github.com/morris821028/UVa/blob/master/volume111/11130%20-%20Billiard%20bounces.cpp
//http://mycliffsnotes.blogspot.com/2014/02/uva-problem-id-11130-billiard-bounces.html
//https://yuting-zhang.github.io/uva/2016/12/25/UVa-11130.html
//https://www.fisicalab.com/apartado/mrua#contenidos


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        int v;
        int angle;
        int s;

        while (true) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            v = scanner.nextInt();
            angle = scanner.nextInt();
            s = scanner.nextInt();

            if(a==0&&b==0&&v==0&&angle==0&&s==0)
                break;

            float acc = -v / (float) s;
            float d = (float) (v * s) + (float) ( 0.5 * acc * s * s);

            double x = d * Math.cos(Math.toRadians(angle)) + a/2;
            double y = d * Math.sin(Math.toRadians(angle)) + b/2;

            System.out.println((int)x/a + " " + (int)y/b);
        }
    }

}

//    public static void main(String[] args)  {
//        Scanner scanner = new Scanner(System.in);
//        int a;
//        int b;
//        int v;
//        int angle;
//        int s;
//        int x;
//        int y;
//        while(true) {
//            a = scanner.nextInt();
//            b = scanner.nextInt();
//            v = scanner.nextInt();
//            angle = scanner.nextInt();
//            s = scanner.nextInt();
//            x=0;
//            y=0;
//            if(a==0&&b==0&&v==0&&angle==0&&s==0)
//                break;
//            int acc = v/s;
//            for(int i=v;i>0;i=i-acc)   {
//                if(angle>45)    {
//                    x = x + i;
//                } else if(angle<45) {
//                    y = y + i;
//                }
//                else    {
//                    x = x + i;
//                    y = y + i;
//                }
//            }
//            System.out.println(y/a+" "+x/b);
//
//        }
//    }
