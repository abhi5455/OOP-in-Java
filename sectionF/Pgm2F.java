import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Pgm2F extends JFrame implements ActionListener {
    JRadioButton redbtn, greenbtn, yellowbtn;
    JButton redBulb, greenBulb, yellowBulb;
    Pgm2F() {
        setBounds(0, 0, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        redbtn = new JRadioButton("RED");
        greenbtn = new JRadioButton("GREEN");
        yellowbtn = new JRadioButton("YELLOW");

        redBulb = new JButton();
        greenBulb = new JButton();
        yellowBulb = new JButton();

        redBulb.setBounds(10, 10, 60, 60);
        yellowBulb.setBounds(10, 80, 60, 60);
        greenBulb.setBounds(10, 150, 60, 60);

        add(redBulb);
        add(yellowBulb);
        add(greenBulb);

        ButtonGroup grp = new ButtonGroup();
        grp.add(redbtn);
        grp.add(greenbtn);
        grp.add(yellowbtn);

        redbtn.setBounds(120, 50, 100, 20);
        yellowbtn.setBounds(120, 70, 100, 20);
        greenbtn.setBounds(120, 90, 100, 20);

        redbtn.addActionListener(this);
        greenbtn.addActionListener(this);
        yellowbtn.addActionListener(this);

        add(redbtn);
        add(greenbtn);
        add(yellowbtn);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == redbtn) {
            redBulb.setBackground(Color.RED);
            yellowBulb.setBackground(Color.WHITE);
            greenBulb.setBackground(Color.WHITE);
        } else if (e.getSource() == greenbtn) {
            redBulb.setBackground(Color.WHITE);
            yellowBulb.setBackground(Color.WHITE);
            greenBulb.setBackground(Color.GREEN);
        } else if (e.getSource() == yellowbtn) {
            redBulb.setBackground(Color.WHITE);
            yellowBulb.setBackground(Color.YELLOW);
            greenBulb.setBackground(Color.WHITE);
        }
    }

    public static void main(String[] args) {
        Pgm2F tr = new Pgm2F();
    }
}
