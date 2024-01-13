package OgInternal;

import OgInternal.model.FocusType;
import OgInternal.model.Trener;
import OgInternal.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

      private Connection connection = null;
      private ConnectionSettings settings;
      private List<Trener> trainers = new ArrayList<>();
      private User user;
      private FocusType selectedFocusType;
      private Trener selectedTrainer;

      public Controller(ConnectionSettings settings) {
            this.settings = settings;
      }

      public static Controller empty() {
            return new Controller(new ConnectionSettings());
      }

      /** geters & seters*/
      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }

      public FocusType getSelectedFocusType() {
            return selectedFocusType;
      }

      public void setSelectedFocusType(FocusType selectedFocusType) {
            this.selectedFocusType = selectedFocusType;
      }

      public List<Trener> getTrainers() {
            return trainers;
      }

      public void setTrainers(List<Trener> trainers) {
            this.trainers = trainers;
      }

      public Trener getSelectedTrainer() {
            return selectedTrainer;
      }

      public void setSelectedTrainer(Trener selectedTrainer) {
            this.selectedTrainer = selectedTrainer;
      }
      /** methods */
      public User login(String username, String password) {
            try {
                  connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
                  System.out.println(connection);
                  PreparedStatement statement = connection.prepareStatement("SELECT u_username, u_password FROM user WHERE u_username=? AND u_password=?");
                  statement.setString(1, username);
                  statement.setString(2, password);
                  ResultSet resultSet = statement.executeQuery();
                  if (resultSet.next()) {
                        user = new User();
                        user.username = resultSet.getString("username_username");
                        user.password = resultSet.getString("username_password");
                  }
            }
            catch (SQLException e) {

            }
            finally {
                  try {
                        connection.close();
                  }
                  catch (SQLException e) {
                        e.printStackTrace();
                  }
            }
            return user;
      }

      public void fetchTrainers() {
            try {
                  trainers.clear();
                  connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
                  System.out.println(connection);
                  PreparedStatement statement = connection.prepareStatement("SELECT trener_id, trener_name, trener_surname, trener_age FROM trener order by trener_id asc ");
                  ResultSet resultSet = statement.executeQuery();
                  while (resultSet.next()) {
                        int id = resultSet.getInt("trener_id");
                        String name = resultSet.getString("trener_name");
                        String surName = resultSet.getString("trener_surname");
                        int age = resultSet.getInt("trener_age");
                        Trener trener = new Trener();
                        trener.setId(id);
                        trener.setName(name);
                        trener.setSurname(surName);
                        trener.setAge(age);
                        trainers.add(trener);
                  }
                  // trainers.forEach( trener -> { System.out.println(trener);} );
            }
            catch (SQLException e) {
            }
            finally {
                  try {
                        connection.close();
                  }
                  catch (SQLException e) {
                        e.printStackTrace();
                  }
            }
      }

      public List<String> fetchMaterialsForSelectedFocus()  {
            List<String> materials = new ArrayList<>();
            try {
                  connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
                  System.out.println(connection);
                  PreparedStatement statement = connection.prepareStatement("SELECT m.materials_name from materials m, materialstofocus mf, focus f WHERE mf.materialstofocus_materials = m.materials_id and mf.materialstofocus_focus = f.focus_id and f.focus_name = ?");
                  String focuseName = this.selectedFocusType.value;
                  statement.setString(1,focuseName );
                  ResultSet resultSet = statement.executeQuery();
                  while (resultSet.next()) {
                        String receivedValue = resultSet.getString("materials_name");
                        materials.add(receivedValue);
                  }
            }
            catch (SQLException e) {
                  return List.of();
            }
            finally {
                  try {
                        connection.close();
                  }
                  catch (SQLException e) {
                        e.printStackTrace();
                  }
            }
            return materials;
      }

      public int getFocusTimeForSelectedFocus(){
            try {
                  connection = DriverManager.getConnection(settings.url, settings.user, settings.pwd);
                  System.out.println(connection);
                  PreparedStatement statement = connection.prepareStatement("SELECT * FROM focus f, focustime ft  where f.focus_time = ft.focustime_id and f.focus_name = ?");
                  String focuseName = this.selectedFocusType.value;
                  statement.setString(1, focuseName);
                  ResultSet resultSet = statement.executeQuery();
                  if (resultSet.next()) {
                        return  resultSet.getInt("focustime_time");
                  }
            }
            catch (SQLException e) {
                  return 0;
            }
            finally {
                  try {
                        connection.close();
                  }
                  catch (SQLException e) {
                        e.printStackTrace();
                  }
            }
            return 0;
      }
}