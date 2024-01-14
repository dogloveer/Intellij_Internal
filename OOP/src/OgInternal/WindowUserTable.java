package OgInternal;

import OgInternal.model.GymView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.List;

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
            fillDataWithGyms();
            ADDNEWButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        new WindowFocus(controller);
                        dispose();
                  }
            });
      }

      private void fillDataWithGyms() {
            List<GymView> gymViews = controller.getGymViews();
            String col[] = {"Focus", "Trener Imie", "Trener Nazwisko", "Czas trwania"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            gymViews.forEach(
                    item -> {
                          tableModel.addRow(new Object[]{item.focusName, item.trainerName, item.trainerSurname, item.focusTime});
                    }
            );
            Jtable.setModel(tableModel);
            Jtable.setBackground(Color.GREEN);
      }

      public static void main(String[] args) {
            new WindowUserTable(Controller.empty());
      }
}
