package OgInternal;

import OgInternal.model.Trener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class WindowSummary extends JFrame {
      private JPanel mainPanel;
      private JLabel TrainingType;
      private JLabel TrainingTime;
      private JLabel TrainingTrainer;
      private JButton OKButton;
      private JTable materialsTable;
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
            setupLabels();
            loadTableData();

      }

      private void setupLabels(){
            TrainingType.setText( controller.getSelectedFocusType().value );
            TrainingTime.setText( String.valueOf(controller.getFocusTimeForSelectedFocus()) );
            Trener trener = controller.getSelectedTrainer();
            TrainingTrainer.setText( trener.getName() + " "+ trener.getSurname());
      }

      private void loadTableData(){
            List<String> materials = controller.fetchMaterialsForSelectedFocus();
            String col[] = {"Materials"};
            DefaultTableModel tableModel = new DefaultTableModel(col, 0);
            materials.forEach(
                    item -> {
                          tableModel.addRow( new Object[] {item} );
                    }
            );
            materialsTable.setModel( tableModel);
      }

}
