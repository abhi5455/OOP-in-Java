import OperatorPrecedence.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Deque;
import java.util.LinkedList;

class MakeCalculator extends JFrame implements ActionListener
{
    JTextField jtxt1 = new JTextField();
    JTextField jtxt2 = new JTextField();
    JButton[] b;
    String[] str={"7", "8","9","*","4","5","6","-","1","2","3","+","^","0",".","="};
    Deque<String> Q =new LinkedList<>();
    double result;
    boolean flag=false;
    OperatorPrecedence OP= new OperatorPrecedence();

    public MakeCalculator()
    {
        this.setTitle("STANDARD CALC");
        this.setSize(401,637);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        jtxt1.setBounds(8,8,372,48);
        jtxt1.setForeground(Color.blue);
        jtxt1.setHorizontalAlignment(SwingConstants.RIGHT);
        jtxt1.setFont(new Font("Ariel",Font.BOLD,20));
        this.add(jtxt1);
        jtxt2.setBounds(100,57,281,67);
        jtxt2.setHorizontalAlignment(SwingConstants.RIGHT);
        jtxt2.setFont(new Font("Ariel",Font.BOLD,30));
        this.add(jtxt2);

        b= new JButton[22];

        b[0]=new JButton("CLEAR");
        b[0].setBounds(8,58,90,65);
        b[0].setFont(new Font("Ariel",Font.BOLD,16));
        b[0].addActionListener(this);
        this.add(b[0]);

        b[1]= new JButton("<");
        b[1].setBounds(8,128,90,90);
        b[1].setFont(new Font("Ariel",Font.BOLD,31));
        b[1].addActionListener(this);
        this.add(b[1]);

        b[2]= new JButton("(");
        b[2].setBounds(102,128,44,90);
        b[2].setFont(new Font("Ariel",Font.PLAIN,27));
        b[2].addActionListener(this);
        this.add(b[2]);

        b[3]= new JButton(")");
        b[3].setBounds(149,128,43,90);
        b[3].setFont(new Font("Ariel",Font.PLAIN,27));
        b[3].addActionListener(this);
        this.add(b[3]);

        b[4]= new JButton("%");
        b[4].setBounds(196,128,90,90);
        b[4].setFont(new Font("Ariel",Font.BOLD,30));
        b[4].addActionListener(this);
        this.add(b[4]);

        b[5]= new JButton("/");
        b[5].setBounds(290,128,90,90);
        b[5].setFont(new Font("Ariel",Font.BOLD,30));
        b[5].addActionListener(this);
        this.add(b[5]);

        int k=6,x=8,y=222,z=0;
        for(int i=0;i<4;i++){
            x=8;
            for(int j=0;j<4;j++){
                b[k]=new JButton(str[z++]);
                b[k].setBounds(x,y,90,90);
                b[k].setFont(new Font("Ariel",Font.BOLD,28));
                b[k].addActionListener(this);
                this.add(b[k++]);
                x+=94;
            }
            y+=94;
    }

        this.setVisible(true);

}
    public void actionPerformed(ActionEvent e)
    {
        JButton b1= (JButton) e.getSource();
        String txt= b1.getText();
        System.out.print(txt);

        try {
            if (txt.equals("CLEAR")) {
                jtxt1.setText(null);
                jtxt2.setText(null);
                System.out.println();
                Q.removeAll(Q);
                flag=false;
            }
            else if (txt.equals("<")) {
                if(isOperator(jtxt1.getText().substring(jtxt1.getText().length()-1))){
                    //For Removing previous operator
                    Q.removeLast();
                    flag2=true;
                }
                jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1));
                jtxt2.setText(jtxt2.getText().substring(0, jtxt2.getText().length() - 1));
            }
            else if (!txt.equals("=")) {

                if ((jtxt1.getText().isEmpty() && txt.equals("-") )) {
                    // Helps to add 1st -ve element
                    jtxt2.setText("-");
                    jtxt1.setText("-");

                }
                else if (txt.equals("-")&&jtxt1.getText().substring(jtxt1.getText().length()-1).equals("(")){
                    jtxt1.setText(jtxt1.getText()+"-");
                    jtxt2.setText("-");
                    return;
                }
                else if (jtxt1.getText().isEmpty() && isOperator(txt)) {
                    // Prevents 1st element as operator
                    return;
                }
                boolean flag2 = false;
                if (isOperator(txt)||isBracket(txt)) {

                    String temp = jtxt1.getText().substring(jtxt1.getText().length() - 1);
                    if (isOperator(temp)&& !isBracket(txt)) {
                        Q.removeLast();
                        Q.add(txt);
                        jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1) + txt);
                        return;
                    }
                    if (!flag&&!txt.equals("(")) {
                        Q.add(jtxt2.getText());
                    }
                    Q.add(txt);
                    flag2 = true;
                    if(isBracket(txt)){
                        jtxt1.setText(jtxt1.getText() + txt);
                        jtxt2.setText(null);
                        return;
                    }
                }
                //sets the 2 textFields
                jtxt1.setText(jtxt1.getText() + txt);
                jtxt2.setText(jtxt2.getText() + txt);

                if (flag2) {
                    jtxt2.setText(null);
                    System.out.println("\nQUEUE " + Q);
                }
            }
            /*else if (txt.equals("=")&& jtxt2.getText().isEmpty()&&Q.size()<=2){
                //THIS CONDITION HANDLES THE CASE OF 1 OPERAND AND 1 OPERATOR (eq: 5+ = 5)
                Q.removeLast(); //REMOVES THE OPERATOR
                jtxt1.setText(Q.peek());
                jtxt2.setText(Q.peek());
                Q.remove(); /* REMOVES THE OPERAND BECAUSE WHEN NEW OPERATOR IS CLICKED,
                               THE OPERAND IS ADDED TO THE QUEUE ONCE AGAIN
            }*/
            else if (txt.equals("=")) {

                flag = true;
                if (jtxt2.getText().isEmpty() && !isBracket(Q.peekLast())) {

                    Q.removeLast();
                    jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1));
                    System.out.println("\nQUEUE " + Q);
                }
                else if(!jtxt2.getText().isEmpty()) {
                    // adds the last operand
                    Q.add(jtxt2.getText());
                }
                System.out.println("\nQUEUE " + Q);
                result= OP.calculate(Q);
                System.out.println("\nRESULT "+result);
                jtxt2.setText(Double.toString(result));
                Q.add(Double.toString(result));
            }
        }catch(Exception e1){
           // e1.printStackTrace();
        }
    }
    private boolean isOperator(String item){
        if (item .equals("%") || item.equals("/") || item.equals("*") || item.equals("-")
                || item.equals("+") || item.equals("^")) {
            return true;
        }
        return false;
    }
    private boolean isBracket(String item){
        if(item.equals("(")||item.equals(")")){
            return true;
        }
        return false;
    }
}

public class Calculator_Pro
{
    public static void main(String[] args) {
        new MakeCalculator();
    }
}
