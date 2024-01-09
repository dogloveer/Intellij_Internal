package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class WindowUserTable extends JFrame {

      private JTable Jtable;
      private JButton ADDNEWButton;
      private JPanel mainPanel;

      private Connection connection = null;

      private Controller controller;

      public WindowUserTable(Controller controller) {
            this.controller = controller;
            setContentPane(mainPanel);
            setSize(900, 500);
            setLocation(200, 100);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            ADDNEWButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        new WindowFocus(controller);
                        dispose();
                  }
            });
      }

      public static void main(String[] args) {
            new WindowUserTable(Controller.empty());
      }
}
