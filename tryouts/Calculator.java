import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class make_cal extends JFrame implements ActionListener {
    int op = 0;
    double result = 0;
    double n = 0;
    JFrame jf;
    JTextField tf;
    JTextField tfu;
    JButton b[];
    JButton b1;

    make_cal() {
        b = new JButton[20];
        jf = new JFrame("calc");
        jf.setSize(412, 635);
        tf = new JTextField();
        tf.setBounds(0, 50, 400, 50);
        tf.setFont(new Font("Arial", Font.BOLD, 40));

        tfu = new JTextField();
        tfu.setBounds(0, 0, 400, 50);
        tfu.setFont(new Font("Arial", Font.BOLD, 20));

        String str = "C<%/789*456-123+^0.=";
        char buttons[] = str.toCharArray();
        int z = 100;

        int x, y;
        x = 0;
        y = 100;

        int k = 0;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 4; j++) {
                String s = String.valueOf(buttons[k]);
                b[k] = new JButton();
                b[k].setText(s);
                b[k].setBounds(x, y, z, z);
                b[k].setFont(new Font("Arial", Font.BOLD, 30));
                jf.add(b[k]);
                b[k].addActionListener(this);
                k++;
                x += 100;

            }
            y += 100;
            x = 0;
        }

        jf.add(tf);
        jf.add(tfu);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(null);
        jf.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        try {


            if (obj == b[0]) {

                tf.setText(null);
                tfu.setText(null);

            } else if (obj == b[1]) {
                if (tf.getText() != null) {
                    tf.setText(tf.getText().substring(0, tf.getText().length() - 1));
                    tfu.setText(tfu.getText().substring(0, tfu.getText().length() - 1));
                } else {
                    tf.setText(null);
                    tfu.setText(null);
                }
            }

            /* else if(obj==b[19])
            {
                String str=tf.getText();
                stacks s=new stacks();

                tf.setText(String.valueOf(s.postfix(str)));


            }
 */


            else if (obj == b[2]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"%");
                tf.setText(null);
                System.out.println(n);
                op = 1;

            } else if (obj == b[3]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"/");
                tf.setText(null);
                System.out.println(n);
                op = 2;
            } else if (obj == b[7]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"*");
                tf.setText(null);
                System.out.println(n);
                op = 3;
            } else if (obj == b[11]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"-");
                tf.setText(null);
                System.out.println(n);
                op = 4;
            } else if (obj == b[15]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"+");
                tf.setText(null);
                System.out.println(n);
                op = 5;
            } else if (obj == b[16]) {

                n = Double.parseDouble(tf.getText());
                tfu.setText(tf.getText()+"^");
                tf.setText(null);
                System.out.println(n);
                op = 6;
            }

            else if ((obj == b[19])) {

                if (op == 1) {

                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = n %m ;
                    System.out.println(result);

                }

                else if (op == 2) {
                    System.out.println("hi");
                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = n / m;

                } else if (op == 3) {
                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = m * n;

                } else if (op == 4) {
                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = n - m;

                } else if (op == 5) {

                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = m + n;

                } else if (op == 6) {
                    double m = Double.parseDouble(tf.getText());
                    System.out.println(m);
                    result = Math.pow(n, m);

                }

                String res = Double.toString(result);
                System.out.println(result);
                System.out.println(res);
                tf.setText(res);
            }


            else {
                for (int i = 0; i < 19; i++) {
                    if (obj == b[i]) {
                        tf.setText(tf.getText() + b[i].getText());
                        tfu.setText(tfu.getText() + b[i].getText());
                    }
                }
            }
        } catch (Exception xe) {
        }
    }

}

public class Calculator  {
    public static void main(String[] args) {
        make_cal a = new make_cal();
    }

}