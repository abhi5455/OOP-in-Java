package OperatorPrecedence;

import java.util.LinkedList;
import java.util.Deque;
import java.util.Stack;

public class OperatorPrecedence {

    protected Deque<String> S= new LinkedList<>();
    protected Stack<Double> ES= new Stack<>();

    protected Deque<String> Q= new LinkedList<>();
    double result;
    String optr;

    public double calculate(Deque<String> Q){
        this.Q=Q;
        ConvertInfixtoPostfix();
        System.out.println(evaluatePostfix());
        return result;
    }
    private double evaluatePostfix(){
        while(!S.isEmpty()) {
            if(S.peek().equals(" ")){
                S.remove();
            }
            if (Check.isOperator(S.peek())) {
                optr = S.remove();
                double x = ES.pop();
                double y = ES.pop();
                switch (optr) {
                    case "%":
                        result = y % x;
                        break;
                    case "/":
                        result = y / x;
                        break;
                    case "*":
                        result = y * x;
                        break;
                    case "-":
                        result = y - x;
                        break;
                    case "+":
                        result = y + x;
                        break;
                    case "^":
                        result = Math.pow(y, x);
                        break;
                }
                ES.push(result);
                if (S.isEmpty()) {
                    return result;
                }
            } else {
                ES.push(Double.parseDouble(S.remove()));
            }
        }
        return 0;
    }
    private void ConvertInfixtoPostfix() {
        Stack<String> S2 = new Stack<>();
        S2.push("(");
        Q.add(")");
        while (!Q.isEmpty()) {

            if(Q.peek().equals("(")){
                S2.push(Q.remove());
            }
            else if(Q.peek().equals(")")){
                while(!S2.peek().equals("(")) {
                    S.add(S2.pop());
                }
                // Removing ")" from S2 and Q
                S2.pop();
                Q.remove();
            }
            else if (!Check.isOperator(Q.peek())) {
                S.add(Q.remove());
            }
            else if(Check.isOperator(Q.peek())){
                while(Check.ICP(Q.peek()) <= Check.ISP(S2.peek())){
                    S.add(S2.pop());
                }
                S2.push(Q.remove());
            }

        }
    }
}
class Check{
    protected static boolean isOperator(String item){
        if (item .equals("%") || item.equals("/") || item.equals("*") || item.equals("-")
                || item.equals("+") || item.equals("^")) {
            return true;
        }
        return false;
    }
    protected static int ISP(String optr){
        switch(optr){
            case "+":
            case "-":
                        return 1;
            case "*":
            case "/":
                        return 3;
            case "^":   return 6;
        }
        return -1;
    }
    protected static int ICP(String optr){
        switch(optr){
            case "+":
            case "-":
                        return 2;
            case "*":
            case "/":
                        return 4;
            case "^":   return 5;
        }
        return -1;
    }
}