package OgInternal;

import OgInternal.model.User;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;

public class WindowSignUp extends JFrame {
    private JTextField NAMETextfield;
    private JTextField SURNAMETextField;
    private JTextField EMAILTextField;
    private JTextField USERNAMETextField;
    private JTextField PASSWORDTextField;
    private JButton CREATEMYACCOUNTButton;
    private JButton BACKButton;
    private JPanel mainPanel;
    private JSlider sliderage;
    private JTextField AGETextField;

    private Connection connection=null;
    JFrame frame = new JFrame();

    public WindowSignUp(){
        super();
        frame.setContentPane(mainPanel);
        frame.setSize(900,500);
        frame.setLocation(200,100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        BACKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new WindowBeginning(); dispose();
                }
            });

        //dragging a mouse to set value
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

        CREATEMYACCOUNTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (NAMETextfield.getText().isEmpty() || SURNAMETextField.getText().isEmpty() || EMAILTextField.getText().isEmpty() || USERNAMETextField.getText().isEmpty() ||PASSWORDTextField.getText().isEmpty() || AGETextField.getText().isEmpty() ){
                    new WindowErrorEmpty();
                } else
                    new WindowSuccess(); dispose();
                String name = NAMETextfield.getText();
                String surname = SURNAMETextField.getText();
                String email = EMAILTextField.getText();
                String username = USERNAMETextField.getText();
                String password = PASSWORDTextField.getText();
                String age = AGETextField.getText();

                try {
                    user = getUser(name,surname,email,username,password,age);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });



        /*

                    else{
                        try {
                            user = getUser(name, surname, username, email, password, rpassword);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(BRconfirm, "Error occurred during registration");
                        }
                    }
                }
        });
    }
    public User user;
    private User getUser(String name, String surname, String username, String email, String password, String rpassword) throws SQLException {
        User user = null;
        ConnectionSettings settings = new ConnectionSettings();
        try {
            connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO register (name_user, surname_user, email_user, user_user, pass_user, rpass_user) VALUES (?,?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.setString(6, rpassword);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                user = new User();
                user.username = username;
                user.password = password;
                user.name = name;
                user.surname = surname;
                user.email = email;
                JOptionPane.showMessageDialog(BRconfirm, "You have successfully registered ");
                new LoginIA();
            } else {
                JOptionPane.showMessageDialog(BRconfirm, "Error occurred during registration");
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
    public static void main(String[] args) {
        RegisterIA register = new RegisterIA();
    }
}
*/
    }
    public User user;
    private User getUser(String name, String surname, String email, String username, String password, String age) throws SQLException {
        User user = null;
        ConnectionSettings settings = new ConnectionSettings();
        try {
            connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user (u_name, u_surname, u_email, u_username, u_password, u_age) VALUES (?,?,?,?,?,?)");
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, email);
            statement.setString(4, username);
            statement.setString(5, password);
            statement.setString(6, age);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                user = new User();
                user.username = username;
                user.password = password;
                user.name = name;
                user.surname = surname;
                user.email = email;
                user.age = Integer.valueOf(age);
               // new WindowSuccess();
                new WindowLogIn();
            }else {
                JOptionPane.showMessageDialog(CREATEMYACCOUNTButton, "Error occurred during registration");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //statement.close();
        connection.close();

        return user;
    }

}
