package bo.edu.umss.algorithms.competitions.contest5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//UVA 11100 - The Trip, 2007
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2041
//https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v111/TheTrip2700_UVa11100.java
//https://github.com/yulonglong/UVa-Solutions/blob/master/11100.cpp
public class Main_C_TheTrip2007 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        while(true)
        {
            int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(N==0)
                break;

            if(first)
                first = false;
            else
                sb.append("\n");

            int[] bags = new int[N];
            int last = -1,count = 0, max= 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
            {
                while(!st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
                bags[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(bags);
            for(int i = 0; i < N; i++)
            {
                int bag = bags[i];
                if(bag==last)
                    count++;
                else
                {
                    max = Math.max(count, max);
                    count = 1;
                }
                last = bag;

            }
            max = Math.max(count, max);
            sb.append(max).append("\n");
            LinkedList<Integer>[] nestedBags = new LinkedList[max];
            for(int i = 0; i < max; i++)
                nestedBags[i] = new LinkedList<>();
            for(int i = 0, j = 0; i < N; i++, j = (j+1)%max)
                nestedBags[j].push(bags[i]);
            for(int i = 0; i < max; i++)
            {
                LinkedList<Integer> cur = nestedBags[i];
                while(!cur.isEmpty())
                    sb.append(cur.pop()).append(cur.isEmpty()?"\n":" ");
            }
        }
        System.out.print(sb);
    }
}
