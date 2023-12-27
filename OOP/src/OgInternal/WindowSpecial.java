package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class WindowSpecial extends JFrame {
    private JPanel mainPanel;
    private JButton BACKButton;
    private JButton OKButton;
    private JTextField CODETextField;
    private JTextField NUMBERTextField;
    private JPanel subMainP;
    private JPanel buttonPanel;

    private Connection connection=null;
    JFrame frame = new JFrame();

    public WindowSpecial() {
        super();
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowBeginning(); dispose();
            }
        });
    }
}
