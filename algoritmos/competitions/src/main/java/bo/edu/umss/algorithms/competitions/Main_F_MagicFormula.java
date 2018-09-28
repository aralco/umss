package bo.edu.umss.algorithms.competitions;

import java.util.Scanner;

class Main_F_MagicFormula {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int L = scanner.nextInt();

            if(a==0&&b==0&&c==0&&d==0&L==0) {
                break;
            } else  {
                int result = 0;
                for(int i=0;i<=L;i++)   {
                    int fi = a*i*i+b*i+c;
                    if(fi%d==0) {
                        result++;
                    }
                }
                System.out.println(result);
            }
        }
    }
}
