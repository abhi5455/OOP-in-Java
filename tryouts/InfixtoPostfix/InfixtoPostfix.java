package InfixtoPostfix;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*public class InfixtoPostfix{
    public static void main(String[] args){
        new InfixtoPostfi();
    }
}*/
public class InfixtoPostfix {

    protected Stack<String> S= new Stack<>();
    protected Stack<String> ES= new Stack<>();

    protected Queue<String> Q= new LinkedList<>();
    String[] str={"(","3","+","2",")","*","5"};
    /*public InfixtoPostfi(){
        int i=0;
        while(i<=6){
            Q.add(str[i++]);
        }
        System.out.println("QUEUE "+Q);
        ConvertInfixtoPostfix();
    }*/
    public void calculate(Queue<String> Q){
        this.Q=Q;
        ConvertInfixtoPostfix();
        evaluatePostfix();
        System.out.println("STACK "+S);
        //return Q;
    }
    private float evaluatePostfix(){

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
                S2.pop();
                Q.remove();
            }
            else if (!Check.isOperator(Q.peek())) {
                S.push(Q.remove());
            }
            else if(Check.isOperator(Q.peek())){
                while(Check.ICP(Q.peek()) <= Check.ISP(S2.peek())){
                    S.add(S2.pop());
                }
                S2.push(Q.remove());
            }

        }

        System.out.println(S);
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