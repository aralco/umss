package bo.edu.umss.algorithms.competitions.contest8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//UVA - 10131 - B - Is Bigger Smarter?
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1072

//https://github.com/PuzzlesLab/UVA/blob/master/King/10131%20Is%20Bigger%20Smarter.java
//https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v101/IsBiggerSmarter_UVa10131.java
//https://tausiq.wordpress.com/2010/04/26/uva-10131/
public class Main_B_IsBiggerSmarter {

    public static void main(String[] args)  throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Elephant> elephants = new ArrayList<>();
        int idCounter = 1;

        String input;
        while ((input=bufferedReader.readLine())!=null) {
            StringTokenizer tokenizer = new StringTokenizer(input);
            Elephant e = new Elephant();
            e.weight = Integer.parseInt(tokenizer.nextToken());
            e.iq = Integer.parseInt(tokenizer.nextToken());
            e.id = idCounter++;
            elephants.add(e);
        }

        Elephant[] elephantArray = elephants.toArray(new Elephant[elephants.size()]);
        Arrays.sort(elephantArray);

        int[] lis = new int [elephantArray.length];
        lis[0]=1;
        for (int i=1;i<lis.length;i++) {
            lis[i]=Math.max(1, lis[i]);
            for (int i2=0;i2<i;i2++) {
                if (elephantArray[i].iq<elephantArray[i2].iq && elephantArray[i].weight>elephantArray[i2].weight) {
                    lis[i]=Math.max(lis[i2]+1, lis[i]);
                }
            }
        }

        int max = 0;
        for(int i : lis)
            max = Math.max(i, max);

        System.out.println(max);
        int[] result = new int[max];

        boolean first = true;
        int last=0;
        for(int i=lis.length-1;i>=0 && max>0;i--) {
            if (lis[i]==max && (first || last<elephantArray[i].iq)) {
                last=elephantArray[i].iq;
                result[--max]=elephantArray[i].id;
                first=false;
            }
        }

        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
    }

    static class Elephant implements Comparable<Elephant> {
        int weight;
        int iq;
        int id;

        public int compareTo(Elephant e) {
            return this.weight-e.weight;
        }
    }
}
