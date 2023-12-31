import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

class Makecalculator extends JFrame implements ActionListener
{
    String[] str= {"C","<","%","/","7","8","9","*","4","5","6","-","1","2","3","+","^","0",".","="};
    JButton b[];
    JTextField jtxt1,jtxt2;
    double n,m,result;
    char op;
    Deque<String> Q= new LinkedList<>();
    int flag=0;

    public Makecalculator()
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
            else if (txt.equals("=")&& !jtxt2.getText().isEmpty()&&Q.size()>=2) {
                /* This Loop activates when '=' is pressed && Last Element is an Operand
                   &&b There is minimum 2 elements in the Queue (1 operand and an operator, the last operand to the
                                                                   Queue is added in this loop )*/

               /*  if(! jtxt2.getText().isEmpty()){
                    //ENSURES WHETHER LAST ELEMENT IS AN OPERAND OR NOT.
                    System.out.println("Enter Last operand");
                    return;
                }*/


                Q.add(jtxt2.getText());     //Adding Last operand to the Queue.

                System.out.println("\nQUEUE "+Q);
                /*if (Q.size() < 3) {
                    System.out.println("Enter 2 operands and and operation");
                    return;
                }*/
                String item1 = Q.remove();
                result = Double.parseDouble(item1);
                while (Q.size() != 0) {

                    if (item1 == "%" || item1 == "/" || item1 == "*" || item1 == "-" || item1 == "+"|| item1=="^") {
                        if (item1 == "%") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result %= item2;
                        } else if (item1 == "/") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result /= item2;
                        } else if (item1 == "*") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result *= item2;
                        } else if (item1 == "-") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result -= item2;
                        } else if (item1 == "+") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result += item2;
                        }else if (item1 == "^") {
                            Double item2 = Double.parseDouble(Q.remove());
                            result = Math.pow(result,item2);
                        }
                    }

                    if (Q.size() == 0) {
                        jtxt2.setText(result + "");
                        System.out.println(result);
                        flag = 1;
                    }
                    item1 = Q.remove();

                }

            }
            else {
                int flag2=0;
                if (txt .equals("%") || txt.equals("/") || txt.equals("*") || txt.equals("-") || txt.equals("+") || txt.equals("^")) {
                    //This Loop Activates when an Operator is Clicked

                    //temp stores the last character of String jtxt1
                    String temp=jtxt1.getText().substring(jtxt1.getText().length()-1,jtxt1.getText().length());

                    if(temp.equals("%") || temp.equals("/") || temp.equals("*") || temp.equals("-") || temp.equals("+") || temp.equals("^")) {
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
        }
        catch(Exception ex) {
            //ex.printStackTrace();
        }
    }
}
public class Calculator_Trial
{
    public static void main(String[] args) {
        Makecalculator c =new Makecalculator();
    }
}