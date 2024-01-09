package OgInternal;

import javax.swing.*;

public class WindowChoose extends JFrame {
      private JTable table1;
      private JComboBox comboBox;
      private JButton CONFIRMButton;
      private JPanel mainPanel;
      private JPanel textPanel;
      private JPanel choosePanel;
      private JPanel tablePanel;
      private Controller controller;
      private JFrame frame = new JFrame();

      public WindowChoose(Controller controller) {
            super();
            this.controller = controller;
            frame.setContentPane(mainPanel);
            frame.setSize(900, 500);
            frame.setLocation(200, 100);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);
            controller.fetchTrainers();
      }



}
