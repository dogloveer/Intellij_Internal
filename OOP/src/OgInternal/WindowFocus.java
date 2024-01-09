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

    private Controller controller;

    public WindowFocus(Controller controller){
        super();
        this.controller = controller;
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);


          CONFIRMButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                      FocusType focusType = getFocusType();
                      controller.setFocusType(focusType);
                      new WindowAddTrainer(controller);
                      dispose();

                }
          });
    }

    private FocusType getFocusType(){

          if (aerobicsRB.isSelected()) return FocusType.AEROBICS;
          if (bodyweightRB.isSelected()) return FocusType.BODYWEIGHT;
          if (crossfitRB.isSelected()) return FocusType.CROSSFITENER;
          if (stretchingRB.isSelected()) return FocusType.STRETCHING;
          if (weightRB.isSelected()) return FocusType.WEIGHT;
          return FocusType.UNKNOWN;
    }


}
