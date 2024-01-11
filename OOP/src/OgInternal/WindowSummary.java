package OgInternal;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

public class WindowSummary extends JFrame{
    private JPanel mainPanel;
    private JLabel TrainingType;
    private JLabel TrainingTime;
    private JLabel TrainingTrainer;
    private JLabel TrainingMaterials;
    private JButton OKButton;
    JFrame frame=new JFrame();

    public WindowSummary(){
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
