package OgInternal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class WindowLogIn extends JFrame{
    private JTextField USERNAMETextField;
    private JButton CLEARButton;
    private JButton BACKButton;
    private JButton OKButton;
    private JPanel mainPanel;
    private JCheckBox showPasswordCheckBox;
    private JPasswordField PASSWORDField;
    private Connection connection=null;
    JFrame frame = new JFrame();


    public WindowLogIn(){
        super();
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
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
                if (showPasswordCheckBox.isSelected()){
                    PASSWORDField.setEchoChar((char) 0);

                }
                else {
                PASSWORDField.setEchoChar('*');
            }}
        });

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (USERNAMETextField.getText().isEmpty() || PASSWORDField.getText().isEmpty()){
                new WindowErrorEmpty(); dispose();
            } else

                new WindowChoose();
                String username = USERNAMETextField.getText();
                String password = String.valueOf(PASSWORDField.getPassword());
                try {
                    user= getUser (username, password);
                } catch (SQLException ex){
                    throw new RuntimeException(ex);
                }

            }
        });

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowBeginning(); dispose();
            }
        });

    }

    public User user;
    private User getUser(String username, String password) throws SQLException {
        User user=null;
        ConnectionSettings settings = new ConnectionSettings();
        try {
            connection = DriverManager.getConnection(settings.url,settings.user, settings.pwd);
            System.out.println(connection);
            PreparedStatement statement = connection.prepareStatement("SELECT u_username, u_password FROM user WHERE u_username=? AND u_password=?");

            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet= statement.executeQuery();
            if(resultSet.next()){
                user= new User();
                user.username=resultSet.getString("u_username");
                user.password=resultSet.getString("u_password");
                //PreparedStatement st = connection.prepareStatement("UPDATE user SET u_true = 't' WHERE u_username="+username);
                JOptionPane.showMessageDialog(OKButton,"You have successfully logged in");
                new WindowUserTable();
            }
            else {
                JOptionPane.showMessageDialog(OKButton,"Incorrect Username or password");
            }
            statement.close();
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }
}



