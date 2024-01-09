package OgInternal;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class WindowAddTrainer extends JFrame {
      private JTextField NAMETextField;
      private JTextField SURNAMETextField;
      private JSlider sliderage;
      private JRadioButton aerobicsRadioButton;
      private JRadioButton bodyweightExcercisesRadioButton;
      private JRadioButton crossfitRadioButton;
      private JRadioButton stretchingRadioButton;
      private JButton CLEARButton;
      private JButton OKButton;
      private JRadioButton weightTrainingRadioButton;
      private JTextField AGETextField;
      private JPanel mainPanel;
      private Controller controller;
      private JFrame frame = new JFrame();

      public WindowAddTrainer(Controller controller) {
            super();
            this.controller = controller;
            frame.setContentPane(mainPanel);
            frame.setSize(900, 500);
            frame.setLocation(200, 100);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            sliderage.addMouseMotionListener(new MouseMotionAdapter() {
                  @Override
                  public void mouseDragged(MouseEvent e) {
                        super.mouseDragged(e);

                        int age1;
                        age1 = sliderage.getValue();
                        AGETextField.setText(Integer.toString(age1));
                  }
            });
            sliderage.addMouseMotionListener(new MouseMotionAdapter() {
                  @Override
                  public void mouseMoved(MouseEvent e) {
                        super.mouseMoved(e);

                        int age2;
                        age2 = sliderage.getValue();
                        AGETextField.setText(Integer.toString(age2));
                  }
            });
            sliderage.addMouseListener(new MouseAdapter() {
                  @Override
                  public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);

                        int age3;
                        age3 = sliderage.getValue();
                        AGETextField.setText(Integer.toString(age3));
                  }
            });

      }
}
