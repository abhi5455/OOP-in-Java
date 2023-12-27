import javax.swing.*;
import java.awt.event.*;

public class Pgm1F extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, addbtn, subbtn, mulbtn, divbtn, eqbtn, clrbtn;
    JTextField t1;
    int op;
    double b, a;

    public Pgm1F() {
        setBounds(50, 50, 420, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        b1 = new JButton("1");
        b1.setBounds(50, 100, 60, 60);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("2");
        b2.setBounds(120, 100, 60, 60);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("3");
        b3.setBounds(190, 100, 60, 60);
        b3.addActionListener(this);
        add(b3);
        addbtn = new JButton("+");
        addbtn.setBounds(260, 100, 60, 60);
        addbtn.addActionListener(this);
        add(addbtn);

        b4 = new JButton("4");
        b4.setBounds(50, 170, 60, 60);
        b4.addActionListener(this);
        add(b4);
        b5 = new JButton("5");
        b5.setBounds(120, 170, 60, 60);
        b5.addActionListener(this);
        add(b5);
        b6 = new JButton("6");
        b6.setBounds(190, 170, 60, 60);
        b6.addActionListener(this);
        add(b6);
        subbtn = new JButton("-");
        subbtn.setBounds(260, 170, 60, 60);
        subbtn.addActionListener(this);
        add(subbtn);
        b7 = new JButton("7");
        b7.setBounds(50, 240, 60, 60);
        b7.addActionListener(this);
        add(b7);
        b8 = new JButton("8");
        b8.setBounds(120, 240, 60, 60);
        b8.addActionListener(this);
        add(b8);
        b9 = new JButton("9");
        b9.setBounds(190, 240, 60, 60);
        b9.addActionListener(this);
        add(b9);
        mulbtn = new JButton("*");
        mulbtn.setBounds(260, 240, 60, 60);
        mulbtn.addActionListener(this);
        add(mulbtn);
        clrbtn = new JButton("<");
        clrbtn.setBounds(50, 310, 60, 60);
        clrbtn.addActionListener(this);
        add(clrbtn);
        b0 = new JButton("0");
        b0.setBounds(120, 310, 60, 60);
        b0.addActionListener(this);
        add(b0);
        eqbtn = new JButton("=");
        eqbtn.setBounds(190, 310, 60, 60);
        eqbtn.addActionListener(this);
        add(eqbtn);
        divbtn = new JButton("/");
        divbtn.setBounds(260, 310, 60, 60);
        divbtn.addActionListener(this);
        add(divbtn);
        t1 = new JTextField();
        t1.setBounds(50, 30, 270, 60);
        t1.setHorizontalAlignment(SwingConstants.RIGHT);
        add(t1);
        setVisible(true);
    }

    public static void main(String[] args) {
        Pgm1F cl = new Pgm1F();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == eqbtn) {
                b = Double.parseDouble(t1.getText());
                switch (op) {
                    case 1:
                        b = b + a;
                        break;
                    case 2:
                        b = a - b;
                        break;
                    case 3:
                        b = b * a;
                        break;
                    case 4:
                        b = a / b;
                        break;
                }
                t1.setText(b + "");
            } else if (e.getSource() == clrbtn) {
                t1.setText("");
                a = 0;
            } else if (e.getSource() == addbtn) {
                op = 1;
                a = Double.parseDouble(t1.getText());
                t1.setText("");
            } else if (e.getSource() == subbtn) {
                op = 2;
                a = Double.parseDouble(t1.getText());
                t1.setText("");

            } else if (e.getSource() == mulbtn) {
                op = 3;
                a = Double.parseDouble(t1.getText());
                t1.setText("");

            } else if (e.getSource() == divbtn) {
                op = 4;
                a = Double.parseDouble(t1.getText());
                t1.setText("");
            } else
                t1.setText(t1.getText() + ((JButton) e.getSource()).getText());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
