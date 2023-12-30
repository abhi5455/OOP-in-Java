import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class makeCalc extends JFrame implements ActionListener
{
    String[] str= {"C","<","%","/","7","8","9","*","4","5","6","-","1","2","3","+","^","0",".","="};
    JButton b[];
    JTextField jtxt1,jtxt2;
    double n,m,result;
    char op;

    public makeCalc()
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
        System.out.println(txt);
        try {
            if (txt == "C") {
                jtxt1.setText(null);
                jtxt2.setText(null);
            }
            else if(txt == "<"){
                if(jtxt2.getText()!=null) {
                    jtxt1.setText(jtxt1.getText().substring(0, jtxt1.getText().length() - 1));
                    jtxt2.setText(jtxt2.getText().substring(0, jtxt2.getText().length() - 1));
                }
                else{
                    jtxt1.setText(null);
                    jtxt2.setText(null);
                }
            }
            else if(txt == "%"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt2.getText()+"%");
                jtxt2.setText(null);
                op='%';
            }
            else if(txt == "/"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt2.getText()+"/");
                jtxt2.setText(null);
                op='/';
            }
            else if(txt == "*"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt2.getText()+"*");
                jtxt2.setText(null);
                op='*';
            }
            else if(txt == "-"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt2.getText()+"-");
                jtxt2.setText(null);
                op='-';
            }
            else if(txt == "+"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt2.getText()+"+");
                jtxt2.setText(null);
                op='+';
            }
            else if(txt == "^"){
                n=Double.parseDouble(jtxt2.getText());
                jtxt1.setText(jtxt1.getText()+"^");
                jtxt2.setText(null);
                op='^';
            }
            else if(txt == "="){
                try {
                    if (op == '%') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = n % m;
                        jtxt2.setText("" + result);
                    } else if (op == '/') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = n / m;
                        jtxt2.setText("" + result);
                    } else if (op == '*') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = n * m;
                        jtxt2.setText("" + result);
                    } else if (op == '-') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = n - m;
                        jtxt2.setText("" + result);
                    } else if (op == '+') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = n + m;
                        jtxt2.setText("" + result);
                    } else if (op == '^') {
                        m = Double.parseDouble(jtxt2.getText());
                        result = Math.pow(n, m);
                        jtxt2.setText("" + result);
                    } else {
                        //Sometimes '=' is pressed after operand 1
                        jtxt1.setText(jtxt1.getText());
                        jtxt2.setText(jtxt1.getText());
                    }
                    System.out.println(n+" "+op+" "+ m+"= "+result);
                }
                catch(Exception e3) {
                    System.out.println("Enter Operand 2");
                }
            }
            else{
                jtxt2.setText(jtxt2.getText()+txt);
                jtxt1.setText(jtxt1.getText()+txt);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
public class Calculator_NS
{
    public static void main(String[] args) {
        makeCalc c=new makeCalc();

    }
}