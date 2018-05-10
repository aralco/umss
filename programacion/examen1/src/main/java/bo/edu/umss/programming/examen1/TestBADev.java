package bo.edu.umss.programming.examen1;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ariel.alcocer
 */
public class TestBADev {
    public static void main(String args[])  {
        System.out.println(avgDistance(1,1,4,4,2,3));
        System.out.println(isCasiPalindromo("abccba"));
        System.out.println(isCasiPalindromo("abccbx"));
        System.out.println(isCasiPalindromo("abccfg"));
        System.out.println(numMasPopular(new Integer[]{34, 31, 34, 77, 82}, 5));
    }

    public static double avgDistance(double x1, double x2, double y1, double y2, double z1, double z2)   {
        return (distanceBetween2Points(x1, x2, y1, y2)+
                distanceBetween2Points(y1, y2, z1, z2)+
                distanceBetween2Points(x1, x2, z1, z2))/3;
    }

    public static double distanceBetween2Points(double x1, double x2, double y1, double y2)  {
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
    }

    public static boolean isCasiPalindromo(String word) {
        int start = 1;
        int end = word.length() - 2;
        boolean isPalindrome = true;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }
        return  isPalindrome;

    }

    public static int numMasPopular(Integer[] array, int size)  {

        return Collections.max(Arrays.asList(array));
    }
}
