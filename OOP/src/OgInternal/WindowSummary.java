package OgInternal;

import javax.swing.*;

public class WindowSummary extends JFrame {
      private JPanel mainPanel;
      private JLabel TrainingType;
      private JLabel TrainingTime;
      private JLabel TrainingTrainer;
      private JLabel TrainingMaterials;
      private JButton OKButton;
      private JFrame frame = new JFrame();
      private Controller controller;


      public WindowSummary(Controller controller) {
            this.controller = controller;
            frame.setContentPane(mainPanel);
            frame.setSize(900, 500);
            frame.setLocation(200, 100);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            controller.getTrainerAndFocus();
      }
}
