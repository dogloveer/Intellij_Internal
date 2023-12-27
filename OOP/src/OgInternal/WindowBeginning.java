package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class WindowBeginning extends JFrame {
    private JPanel mainPanel;
    private JButton LOGINButton;
    private JButton SIGNUPButton;
    private JButton SPECIALButton;

    private Connection connection = null;


    public WindowBeginning() {

        SIGNUPButton.setText("<html>New member?<br />SIGN UP<html>");
        LOGINButton.setText("<html>Already a member?<br />LOG IN<html>");
        SPECIALButton.setText("<html>Do you have special access?<br /> Click here<html>");

        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowLogIn(); dispose();
            }
        });

        SIGNUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowSignUp(); dispose();
            }
        });

        setContentPane(mainPanel);
        setSize(900, 500);
        setLocation(200, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        SPECIALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowSpecial(); dispose();
            }
        });
    }

    public static void main(String[] args) {
        new WindowBeginning();
    }
}


