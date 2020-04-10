package bo.edu.umss.algorithms.exams.third;

import java.util.Scanner;

public class AcceptableNumbers {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String n = scanner.nextLine();
            if(n.equals("0"))
                break;
            compute(n);
        }
    }

    static void compute(String number) {
        String incorrect = "INCORRECTO";
        boolean empty = false;
        boolean rule1 = false;
        if(number.contains("0") || !number.contains("2"))
            System.out.println(incorrect);
        else    {
            int pointer2 = number.lastIndexOf("2");
            StringBuilder x = new StringBuilder();
            StringBuilder y = new StringBuilder();
            while(pointer2>=0)   {
                if(!rule1 && number.charAt(pointer2)=='2')    {
                    String suffix2 = number.substring(pointer2+1);
                    if(!suffix2.equals("")) {
                        rule1 = true;
                        x.append(suffix2);
                        y.append(suffix2);
                    }
                    else if(pointer2==0)   {
                        empty = true;
                        break;
                    }
                }
                if(rule1 && number.charAt(pointer2)=='3')    {
                    y = new StringBuilder();
                    y.append(x).append("2").append(x);
                    x = new StringBuilder();
                    x.append(y);
                }
                pointer2--;
            }
            if(!empty && rule1)    {
                System.out.println(y);
            }
            else
                System.out.println(incorrect);
        }
    }
}

/*
20
33289
22
32
42
238394
78
0

INCORRECTO
89289289289
2
INCORRECTO
INCORRECTO
38394
INCORRECTO

*/