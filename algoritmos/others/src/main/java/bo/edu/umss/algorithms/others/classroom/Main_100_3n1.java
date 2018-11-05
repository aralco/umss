package bo.edu.umss.algorithms.others.classroom;

//UVA - 100 - The 3n + 1 problem
//https://uva.onlinejudge.org/index.php?Itemid=8&option=com_onlinejudge&page=show_problem&problem=36

//http://www.algorithmist.com/index.php/UVa_100
//https://tausiq.wordpress.com/2008/12/09/uva-100-the-3n-1-problem/
//https://www.mathblog.dk/uva-100-3n-plus-1-problem/
//http://acm-solution.blogspot.com/2010/11/acm-uva-100-3n-1-problem-java.html
//https://blog.adilakhter.com/2013/02/21/1729/

//		Problem	Verdict	                               Language	Run Time	Submission Date
//      22250713	100	The 3n + 1 problem	Accepted	JAVA	0.300	2018-11-05 04:08:44
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_100_3n1 {
    static Map<Long, Integer> memo = new HashMap<>(0);
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input=bufferedReader.readLine())!=null)  {
            StringTokenizer tokenizer = new StringTokenizer(input);
            int i=Integer.parseInt(tokenizer.nextToken());
            int j=Integer.parseInt(tokenizer.nextToken());
            int max = 0;
            boolean jGreater = false;
            if(i>j) {
                int tmp = j;
                j = i;
                i = tmp;
                jGreater = true;
            }
            for(long n=i;n<=j;n++)   {
                int cycleLength = cycleLenght(n);
                if(cycleLength>max)
                    max = cycleLength;
            }
            if(jGreater)
                System.out.println(j+" "+i+" "+max);
            else
                System.out.println(i+" "+j+" "+max);
        }
    }

    static int cycleLenght(long n)   {
        if(memo.containsKey(n))
            return memo.get(n);
        if(n==1)
            return 1;
        int result = 1 + cycleLenght(nextN(n));
        memo.put(n, result);
        return result;
    }

    static long nextN(long n) {
        if(n%2==0)
            n = n/2;
        else
            n = 3*n+1;
        return n;
    }

}
