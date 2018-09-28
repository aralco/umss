package bo.edu.umss.algorithms.competitions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_D_DifferentDigits {
    public static void main(String[] args)  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringTokenizer tokenizer;
        int n;
        int m;

        try {
            while((input = bufferedReader.readLine())!=null) {
                tokenizer = new StringTokenizer(input);
                n = Integer.parseInt(tokenizer.nextToken());
                m = Integer.parseInt(tokenizer.nextToken());

                int result = 0;
                for(int i=n;i<=m;i++)   {
                    int[] fi = getNumberFrequency(i);
                    if(!hasRepeatedDigits(fi))  {
                        result++;
                    }
                }
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static int[] getNumberFrequency(int n) {
        int[] result = new int[10];
        int dividend = n;
        int quotient;
        int remainder;
        while(dividend>0) {
            remainder = dividend%10;
            quotient = dividend/10;
            result[remainder] = result[remainder]+1;
            dividend=quotient;
        }
        return result;
    }

    static boolean hasRepeatedDigits(int[] digits)   {
        boolean hasRepeatedDigit = false;
        int i=0;
        while(!hasRepeatedDigit && i<digits.length) {
            if(digits[i]>1) {
                hasRepeatedDigit = true;
            }
            i++;
        }
//        for(int i=0;i<digits.length;i++)   {
//            if(digits[i]>1) {
//                hasRepeatedDigit = true;
//                break;
//            }
//        }
        return hasRepeatedDigit;
    }
}
