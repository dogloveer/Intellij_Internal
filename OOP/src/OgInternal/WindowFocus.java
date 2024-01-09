package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class WindowFocus extends JFrame {
    private JPanel mainPanel;
    private JRadioButton aerobicsRB;
    private JRadioButton bodyweightRB;
    private JRadioButton crossfitRB;
    private JRadioButton stretchingRB;
    private JRadioButton weightRB;
    private JButton CONFIRMButton;

    private Connection connection = null;
    JFrame frame = new JFrame();


    public WindowFocus(){
        super();
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        };



        aerobicsRB.addActionListener(listener);
        bodyweightRB.addActionListener(listener);
        crossfitRB.addActionListener(listener);
        stretchingRB.addActionListener(listener);
        weightRB.addActionListener(listener);
    }
}
