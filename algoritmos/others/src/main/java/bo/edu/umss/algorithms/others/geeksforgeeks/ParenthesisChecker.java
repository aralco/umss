package bo.edu.umss.algorithms.others.geeksforgeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class ParenthesisChecker {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bufferedReader.readLine());
        String input;
        for(int i=1;i<=t;i++)   {
            input = bufferedReader.readLine();
            if(parensMatch(input))  {
                System.out.println("balanced");
            } else  {
                System.out.println("not balanced");
            }
        }
    }

    static boolean parensMatch0(String sentence){
        boolean result = true;
        char[] sentences = sentence.toCharArray();
        LinkedList<String > list = new LinkedList<>();
        for(char s :sentences)  {
            if(s=='(')  {
                list.add(String.valueOf(s));
            }else if(s=='['){
                list.add(String.valueOf(s));
            }else if(s=='{'){
                list.add(String.valueOf(s));
            } else if(s==')'){
                if(!list.isEmpty() && list.removeLast().equals("("))
                    result = true;
                else    {
                    result = false;
                    break;
                }
            }else if(s==']'){
                if(!list.isEmpty() && list.removeLast().equals("["))
                    result = true;
                else    {
                    result = false;
                    break;
                }
            }else if(s=='}'){
                if(!list.isEmpty() && list.removeLast().equals("{"))
                    result = true;
                else    {
                    result = false;
                    break;
                }
            }
        }
        if(!list.isEmpty())
            result = false;
        return result;
    }

    //best Solution
    static boolean parensMatch(String sentence){
        boolean result = true;
        char[] sentences = sentence.toCharArray();
        LinkedList<String > list = new LinkedList<>();
        for(char s :sentences)  {
            if(s=='(' || s=='[' || s=='{'){
                list.add(String.valueOf(s));
            } else if(s==')' || s==']' || s=='}'){
                if(!(!list.isEmpty() && isBalanced(list.removeLast(), String.valueOf(s)))) {
                    result = false;
                    break;
                }
            }
        }
        if(result && !list.isEmpty())
            result = false;
        return result;
    }

    static boolean isBalanced(String open, String close) {
        boolean result = false;
        switch (open)  {
            case "(":
                result = close.equals(")");
                break;
            case "[":
                result = close.equals("]");
                break;
            case "{":
                result = close.equals("}");
                break;
        }
        return result;
    }
}
