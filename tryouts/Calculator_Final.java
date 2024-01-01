import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Deque;
import java.util.LinkedList;

class makeCalcu extends JFrame implements ActionListener
{
    String[] str= {"C","<","%","/","7","8","9","*","4","5","6","-","1","2","3","+","^","0",".","="};
    JButton[] b;
    JTextField jtxt1,jtxt2;
    double result;
    Deque<String> Q= new LinkedList<>();
    int flag=0;

    public makeCalcu()
    {
        this.setTitle("CALC");
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(425,675);
        this.setResizable(false);
        this.setLayout(null);

        jtxt1=new JTextField();
        jtxt2=new JTextField();
        this.add(jtxt1);
        this.add(jtxt2);
        jtxt1.setBounds(8,10,396,50);
        jtxt1.setDisabledTextColor(Color.red);
        jtxt1.setFont(new Font("Arial", Font.BOLD, 20));
        jtxt1.setHorizontalAlignment(SwingConstants.RIGHT);
        jtxt1.setForeground(Color.blue);
        jtxt2.setBounds(8,60,396,75);
        jtxt2.setFont(new Font("Arial", Font.BOLD, 35));
        jtxt2.setHorizontalAlignment(SwingConstants.RIGHT);

        int k=0,x=8,y=135;
        b = new JButton[20];
        for (int i = 0; i <5; i++) {
            for (int j = 0; j <4; j++) {
                b[k] = new JButton();
                b[k].setText(str[k]);
                b[k].setBounds(x, y, 95, 95);
                b[k].setFont(new Font("Arial", Font.BOLD, 28));
                this.add(b[k]);
                b[k++].addActionListener(this);
                x += 100;
            }
            x=8;
            y +=100;
        }
        b[0].setFont(new Font("Arial", Font.BOLD, 40));
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton b1=(JButton)e.getSource();
        String txt= b1.getText();
        System.out.print(txt);
        try {
            if (txt.equals("C")) {
                flag=0;
                jtxt1.setText(null);
                jtxt2.setText(null);
                while (Q != null) {
                    Q.remove();
                }
            }
            else if (txt.equals("<")) {
                if (flag == 0) {
                    //THE BLOCK CHECKS WHETHER '=' is PRESSED OR NOT
                    if(isOperator(Q.peekLast())){
                        //FOR DELETING AN OPERATOR
                        Q.removeLast();
                        System.out.println("\nQUEUE "+Q);
                        jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1));
                    }
                    System.out.println(jtxt2.getText().substring(0, jtxt2.getText().length() - 1));
                    //FOR DELETING NUMBERS
                    jtxt2.setText(jtxt2.getText().substring(0, jtxt2.getText().length() - 1));
                    jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1));
                }
                else
                    System.out.println(" CLEAR THE SCREEN");
                // Q.removeLast();

            }
            else if(b1.getText()!= "="){
                int flag2=0;
                if (isOperator(txt)) {
                    //This Loop Activates when an Operator is Clicked

                    //temp stores the last character of String jtxt1
                    String temp=jtxt1.getText().substring(jtxt1.getText().length()-1);

                    if(isOperator(temp)) {
                        //This Loop will not allow 2 operators to occur simultaneously.
                        Q.removeLast();
                        Q.add(b1.getText());
                        jtxt1.setText((jtxt1.getText().substring(0,jtxt1.getText().length()-1) + txt));
                        return;
                    }
                    Q.add(jtxt2.getText());     //To add the previous number to the Queue.
                    Q.add(b1.getText());    //To add the previous operator to the Queue.
                    flag2=1;
                }

                //To set the 2 Textfields Correspondingly when Buttons are pressed
                jtxt1.setText(jtxt1.getText() + txt);
                jtxt2.setText(jtxt2.getText() + txt);
                if(flag2==1){
                    // Clears the 2nd TextField when an operator is Encountered.
                    jtxt2.setText(null);
                    System.out.println("\nQUEUE "+Q);

                }
            }
            else if (txt.equals("=")) {
                // This Loop activates when '=' is pressed.

                if( jtxt2.getText().isEmpty()){
                    //ENSURES WHETHER LAST ELEMENT IS AN OPERAND OR NOT.
                    //THIS CONDITION ALSO HANDLES THE CASE OF 1 OPERAND AND 1 OPERATOR (eg: 5+ = 5)
                    Q.removeLast();
                    jtxt1.setText(jtxt1.getText().substring(0,jtxt1.getText().length()-1));
                    calculateValue();
                }
                else {
                    Q.add(jtxt2.getText());     //Adding Last operand to the Queue.
                    calculateValue();           //Calulates the Result
                }
            }
        }
        catch(Exception ex) {
            //ex.printStackTrace();
        }
    }
    private boolean isOperator(String item){
        if (item .equals("%") || item.equals("/") || item.equals("*") || item.equals("-") 
                || item.equals("+") || item.equals("^")) {
            return true;
        }
        return false;
    }
    private void calculateValue(){
        //This Function Calulates the Result
        try {
            System.out.println("\nQUEUE " + Q);

            String item1 = Q.remove();
            result = Double.parseDouble(item1);
            while (!Q.isEmpty()) {
                double item2;
                if (isOperator(item1)) {
                    switch (item1) {
                        case "%":
                            item2 = Double.parseDouble(Q.remove());
                            result %= item2;
                            break;
                        case "/":
                            item2 = Double.parseDouble(Q.remove());
                            result /= item2;
                            break;
                        case "*":
                            item2 = Double.parseDouble(Q.remove());
                            result *= item2;
                            break;
                        case "-":
                            item2 = Double.parseDouble(Q.remove());
                            result -= item2;
                            break;
                        case "+":
                            item2 = Double.parseDouble(Q.remove());
                            result += item2;
                            break;
                        case "^":
                            item2 = Double.parseDouble(Q.remove());
                            result = Math.pow(result, item2);
                            break;

                    }
                }
                item1 = Q.remove();
            }
        }catch(Exception e3){
            //e3.printStackTrace();
        }
        finally{
            jtxt2.setText(result + "");
            System.out.println(result);
            flag = 1;
        }
    }
}
public class Calculator_Final
{
    public static void main(String[] args) {
        new makeCalcu();
    }
}
