package bo.edu.umss.algorithms.competitions.contest6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//UVA - 10306 - F - e-Coins
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1247
//https://github.com/PuzzlesLab/UVA/blob/master/King/10306%20e-Coins.java
//https://blog.csdn.net/kkkwjx/article/details/17636863
//https://f0rth3r3c0rd.wordpress.com/2011/09/05/uva-10306-e-coins/
//https://www.cnblogs.com/riskyer/p/3327586.html
//http://nminhtu94.blogspot.com/2013/02/uva-10306-e-coins.html
//http://blog.tobygameac.com/2013/08/uva-10306-e-coins.html
//http://www.voidcn.com/article/p-medlzlzv-br.html
public class Main_F_e_Coins {

    public static void main(String[]args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int t=0;t<n;t++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());

            int [][] coins=new int [m][2];
            for (int i=0;i<m;i++) {
                st=new StringTokenizer(br.readLine());
                coins[i][0]=Integer.parseInt(st.nextToken());
                coins[i][1]=Integer.parseInt(st.nextToken());
            }

            dp=new int [301][301];
            flag=new boolean [301][301];
            for (int[] dpS : dp) {
                Arrays.fill(dpS, 12345678);
            }

            int result=Integer.MAX_VALUE;
            for (int i=0;i<=s;i++) {
                for (int i2=0;i2<=s;i2++) {
                    double sqrt=Math.sqrt(i*i+i2*i2);
                    if ((sqrt==(double)(int)sqrt && sqrt==s)) {
                        result=Math.min(result, eModulus(coins,i,i2));
                    } else if (sqrt>s) {
                        break;
                    }
                }
            }

            if (result==12345678) {
                System.out.println("not possible");
            } else {
                System.out.println(result);
            }

            br.readLine(); //empty
        }
    }

    static int eModulus(int [][] coins, int a, int b) {
        if (!flag[a][b]) {
            flag[a][b]=true;
            if (a==0 && b==0) {
                dp[a][b]=0;
            } else {
                for (int i=0;i<coins.length;i++) {
                    if (a>=coins[i][0] && b>=coins[i][1]) {
                        dp[a][b]=Math.min(dp[a][b],1+ eModulus(coins,a-coins[i][0],b-coins[i][1]));
                    }
                }
            }
        }
        return dp[a][b];
    }
    static int [][] dp;
    static boolean [][] flag;
}
