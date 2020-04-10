package bo.edu.umss.algorithms.competitions.contest10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//UVA - 622 - Grammar Evaluation
//https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=563

//https://github.com/rezwan4029/UVA-CODES/blob/master/622%20-%20Grammar%20Evaluation.java
//https://uva.onlinejudge.org/board/viewtopic.php?t=3842
//http://uvacode.blogspot.com/2011/05/hints-for-uva-problem-set-600.html
//http://xacid.blogspot.com/2010/08/uva-622-grammar-evaluation.html
//https://xoptutorials.com/index.php/2017/02/15/uva622/
//http://sound-system-79.blogspot.com/2016/09/uva-622-grammar-evaluation.html
//http://mypaper.pchome.com.tw/zerojudge/post/1323972130
//http://www.voidcn.com/article/p-qsttidxb-cx.html
//http://wuli2496.lofter.com/post/3ae576_433b1f3

//http://matt.might.net/articles/parsing-regex-with-recursive-descent/
//https://en.wikipedia.org/wiki/Recursive_descent_parser
//https://www.spigotmc.org/threads/question-evaluate-string-as-expression-java-8.186714/

public class Main_A_GrammarEvaluation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(bufferedReader.readLine());
        for(int t=1;t<=testCases;t++)   {
            String input = bufferedReader.readLine();
            if(containsValidTokens(input))
                parseAndEvaluateGrammar(input);
            else
                System.out.println("ERROR");

        }
    }

    static void parseAndEvaluateGrammar(String s)   {
        if(parseIsValid(s))
            System.out.println(evaluate(s));
        else
            System.out.println("ERROR");

    }

    static boolean parseIsValid(String s)    {
        int bracket = 0 ;
        for( int i = 0 ; i < s.length() ; i++ ){
            if(Character.isDigit(s.charAt(i))) continue;
            if( s.charAt(i) == '(' ) bracket++;
            else if( s.charAt(i) == ')' ) bracket--;
            if( bracket < 0 ) return false;
            else if( (s.charAt(i) == '(' ) && ( i != 0 && Character.isDigit(s.charAt(i-1)) ) ) return false ;
            else if( (s.charAt(i) == ')' ) && ( isOperator(s.charAt(i-1)) || s.charAt(i) == '(' ) ) return false ;
            else if( i == 0 && s.charAt(i) != '(' )return false;
            else if( i != 0 && isOperator(s.charAt(i)) && ( isOperator(s.charAt(i-1))|| s.charAt(i-1) == '(' ) )return false;
        }
        return bracket == 0;
    }

    static int evaluate(String s) {
        LinkedList<Integer> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                op.add('(');
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st, op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && precedence(op.getLast()) >= precedence(c))
                    processOperator(st, op.removeLast());
                op.add(c);
            } else {
                StringBuilder operand = new StringBuilder();
                while(i < s.length() && Character.isDigit(s.charAt(i)))
                    operand.append(s.charAt(i++));
                --i;
                st.add(Integer.parseInt(operand.toString()));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
        return st.get(0);
    }

    static void processOperator(LinkedList<Integer> st, char op) {
        int r = st.removeLast();
        int l = st.removeLast();
        if(op == '+')
            st.add(l+r);
        else if( op == '*')
            st.add(l*r);
    }
    static int precedence(char op) {
        if( op == '+')
            return 1 ;
        if( op == '*')
            return 2 ;
        return -1;
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '*';
    }

    static boolean containsValidTokens(String s)    {
        return s.matches("[0-9*+()]*");
    }

    static class Parser{
        String s;
        Parser(String s)    {
            this.s = s;
        }

        Parser parse()  {
            return null;
        }

        Parser expression() {
            return null;
        }

        Parser component()  {
            return null;
        }

        Parser factor() {
            return null;
        }

        Integer positiveInteger()   {
            return 0;
        }

        Character sumOperator() {
            return '+';
        }

        Character productOperator() {
            return '*';
        }

        Character openParenthesis() {
            return '(';
        }

        Character closeParenthesis()    {
            return ')';
        }


    }
}
