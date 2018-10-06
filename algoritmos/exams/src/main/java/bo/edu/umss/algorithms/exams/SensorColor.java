package bo.edu.umss.algorithms.exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SensorColor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String guide = br.readLine();
        StringBuilder sb = new StringBuilder(guide);
        String command;
        StringTokenizer stringTokenizer;
        int pos;
        String color;
        int iniz;
        int finz;
        for(int i=0;i<n;i++)    {
            command = br.readLine();
            stringTokenizer = new StringTokenizer(command);
            if(stringTokenizer.nextToken().equals("P")) {
                pos = Integer.parseInt(stringTokenizer.nextToken());
                color = stringTokenizer.nextToken();
                sb.replace(pos,pos+1, color);
            } else  {
                iniz = Integer.parseInt(stringTokenizer.nextToken());
                finz = Integer.parseInt(stringTokenizer.nextToken());
                String tmp = sb.substring(iniz, finz);
                int[] ranking = new int[] {0,0,0};
                for(char c:tmp.toCharArray())  {
                    switch (c)  {
                        case 'B': ranking[0] = ranking[0]+1;
                            break;
                        case 'G': ranking[1] = ranking[1]+1;
                            break;
                        case 'W': ranking[2] = ranking[2]+1;
                            break;
                    }
                }
                if(ranking[0]>0)
                    System.out.println("B");
                else if(ranking[1]>0)   {
                    System.out.println("G");
                } else  {
                    System.out.println("W");
                }
            }

        }
    }
}
