package OgInternal;

import OgInternal.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class WindowLogIn extends JFrame {
      private JTextField USERNAMETextField;
      private JButton CLEARButton;
      private JButton BACKButton;
      private JButton OKButton;
      private JPanel mainPanel;
      private JCheckBox showPasswordCheckBox;
      private JPasswordField PASSWORDField;
      private Connection connection = null;
      JFrame frame = new JFrame();
      private ConnectionSettings settings = new ConnectionSettings();
      private Controller controller = new Controller(settings);

      public WindowLogIn() {
            super();
            frame.setContentPane(mainPanel);
            frame.setSize(900, 500);
            frame.setLocation(200, 100);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true);


            CLEARButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        USERNAMETextField.setText("");
                        PASSWORDField.setText("");
                  }
            });

            showPasswordCheckBox.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        if (showPasswordCheckBox.isSelected()) {
                              PASSWORDField.setEchoChar((char) 0);

                        } else {
                              PASSWORDField.setEchoChar('*');
                        }
                  }
            });

            OKButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        if (USERNAMETextField.getText().isEmpty() || PASSWORDField.getText().isEmpty()) {
                              new WindowErrorEmpty();
                              dispose();
                        }
                        String username = USERNAMETextField.getText();
                        String password = String.valueOf(PASSWORDField.getPassword());
                        try {
                              executeLogin(username, password);
                        }
                        catch (SQLException ex) {
                              throw new RuntimeException(ex);
                        }
                  }
            });

            BACKButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        new WindowBeginning();
                        dispose();
                  }
            });

      }

      private void executeLogin(String username, String password) throws SQLException {
            User user = controller.login(username, password);
            if (user != null) {
                  new WindowUserTable(controller);
            } else {
                  JOptionPane.showMessageDialog(OKButton, "Incorrect Username or password");
            }
      }
}



