package bo.edu.umss.algorithms.exams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumeroInfinito {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int i;
        String seq = "11212312341234512345612345671234567812345678912345678910123456789101112345678910";
        for(int j=0;j<t;j++)    {
            i = Integer.parseInt(br.readLine());
            System.out.println(seq.substring(i-1,i));
        }
    }

}
