package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

      private User user;

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
                        } //else
                              //new WindowChoose();
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
            ConnectionSettings settings = new ConnectionSettings();
            try {
                  Controller controller = new Controller(settings);
                  connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
                  System.out.println(connection);
                  PreparedStatement statement = connection.prepareStatement("SELECT username_username, username_password FROM username WHERE username_username=? AND username_password=?");
                  statement.setString(1, username);
                  statement.setString(2, password);
                  ResultSet resultSet = statement.executeQuery();
                  if (resultSet.next()) {
                        user = new User();
                        user.username = resultSet.getString("username_username");
                        user.password = resultSet.getString("username_password");
                        //PreparedStatement st = connection.prepareStatement("UPDATE user SET u_true = 't' WHERE u_username="+username);
                        JOptionPane.showMessageDialog(OKButton, "You have successfully logged in");
                        controller.setUser(user);
                        new WindowUserTable(controller);
                  } else {
                        JOptionPane.showMessageDialog(OKButton, "Incorrect Username or password");
                  }
                  statement.close();

            }
            catch (SQLException throwables) {
                  throwables.printStackTrace();
            }
            finally {
                  connection.close();
            }

      }
}



