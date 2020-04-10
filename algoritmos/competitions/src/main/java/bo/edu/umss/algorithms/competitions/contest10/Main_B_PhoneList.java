package bo.edu.umss.algorithms.competitions.contest10;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//UVA - 11362 - Phone List
//https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=2347
public class Main_B_PhoneList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++)   {
            int n = scanner.nextInt();
            List<String> phones = new ArrayList<>(n);
            for(int i=0;i<n;i++)    {
                phones.add(scanner.next());
            }
            Collections.sort(phones);
            askIfPhoneListConsistent(phones);
        }
    }

    static void askIfPhoneListConsistent(List<String> phones)  {
        boolean isConsistent = true;
        for(int i=0;i<phones.size()-1;i++)    {
            if(phones.get(i+1).startsWith(phones.get(i))) {
                isConsistent=false;
                break;
            }
        }
        System.out.println(isConsistent?"YES":"NO");
    }
}
