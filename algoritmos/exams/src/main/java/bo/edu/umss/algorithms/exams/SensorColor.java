package bo.edu.umss.algorithms.exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SensorColor {
    //Better Solution
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String guide = br.readLine();
        char[] guides = guide.toCharArray();
        String command;
        StringTokenizer stringTokenizer;
        int pos;
        int iNiz;
        int fInz;
        char result='z';
        for(int i=0;i<n;i++)    {
            command = br.readLine();
            stringTokenizer = new StringTokenizer(command);
            if(stringTokenizer.nextToken().equals("P")) {
                pos = Integer.parseInt(stringTokenizer.nextToken());
                guides[pos] = stringTokenizer.nextToken().charAt(0);
            } else  {
                iNiz = Integer.parseInt(stringTokenizer.nextToken());
                fInz = Integer.parseInt(stringTokenizer.nextToken());
                for(int z=iNiz;z<=fInz;z++) {
                    if(guides[z]=='B')  {
                        result = 'B';
                        break;
                    }
                    else if(guides[z]=='G')
                        result='G';
                    else
                        result='W';
                }
                System.out.println(result);
            }

        }
    }

    //Naive Solution
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String guide = br.readLine();
//        StringBuilder sb = new StringBuilder(guide);
//        String command;
//        StringTokenizer stringTokenizer;
//        int pos;
//        String color;
//        int iNiz;
//        int fInz;
//        for(int i=0;i<n;i++)    {
//            command = br.readLine();
//            stringTokenizer = new StringTokenizer(command);
//            if(stringTokenizer.nextToken().equals("P")) {
//                pos = Integer.parseInt(stringTokenizer.nextToken());
//                color = stringTokenizer.nextToken();
//                sb.replace(pos,pos+1, color);
//            } else  {
//                iNiz = Integer.parseInt(stringTokenizer.nextToken());
//                fInz = Integer.parseInt(stringTokenizer.nextToken());
//                String tmp = sb.substring(iNiz, fInz);
//                int[] ranking = new int[] {0,0,0};
//                for(char c:tmp.toCharArray())  {
//                    switch (c)  {
//                        case 'B': ranking[0] = ranking[0]+1;
//                            break;
//                        case 'G': ranking[1] = ranking[1]+1;
//                            break;
//                        case 'W': ranking[2] = ranking[2]+1;
//                            break;
//                    }
//                }
//                if(ranking[0]>0)
//                    System.out.println("B");
//                else if(ranking[1]>0)   {
//                    System.out.println("G");
//                } else  {
//                    System.out.println("W");
//                }
//            }
//
//        }
//    }
}
