package bo.edu.umss.algorithms.competitions.contest6;

import java.util.Scanner;

//UVA - 108 - A - Maximun Sum
// https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=44
//http://patrickragi.blogspot.com/2012/09/uva-108-maximum-sum.html
public class Main_A_MaximumSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] array = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                array[i][j]=s.nextInt();
            }
        }

        int total=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int []sum=new int[n];
            for(int j=i;j<n;j++){
                int local=Integer.MIN_VALUE;
                int tempSum=0;
                for(int k=0;k<n;k++){
                    sum[k]+=array[j][k];
                    tempSum+=sum[k];
                    local=Math.max(local, tempSum);
                    if(tempSum<0)
                        tempSum=0;
                }
                total=Math.max(local, total);
            }
        }
        System.out.println(total);
    }
}
