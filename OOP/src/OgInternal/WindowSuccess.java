package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class WindowSuccess extends JFrame{
    private JPanel panel1;
    private JButton OKButton;

    private Connection connection = null;

    public WindowSuccess(){
        setContentPane(panel1);
        setSize(450, 250);
        setLocation(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
