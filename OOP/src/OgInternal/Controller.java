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

      /**
       * geters & seters
       */
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

      /**
       * methods
       */
      public User login(String username, String password) {
            try {
                  connection = getConnection();
                  PreparedStatement statement = connection.prepareStatement("SELECT u_id, u_username, u_password FROM user WHERE u_username=? AND u_password=?");
                  statement.setString(1, username);
                  statement.setString(2, password);
                  ResultSet resultSet = statement.executeQuery();
                  if (resultSet.next()) {
                        user = new User();
                        user.id = resultSet.getInt("u_id");
                        user.username = resultSet.getString("u_username");
                        user.password = resultSet.getString("u_password");
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

      public void fetchTrainersForSelectedFocus() {
            try {
                  String selectedFocusValue = this.selectedFocusType.value;
                  trainers.clear();
                  connection = getConnection();
                  PreparedStatement statement = connection.prepareStatement("SELECT t.trener_id, t.trener_name, t.trener_surname, t.trener_age FROM trener t, focus f, trenertofocus tf where tf.trenertofocus_trener = t.trener_id and f.focus_id = tf.trenertofocus_focus and f.focus_name = ? order by t.trener_id asc;");
                  statement.setString(1, selectedFocusValue);
                  ResultSet resultSet = statement.executeQuery();
                  while (resultSet.next()) { // relacja x:y
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

      public List<String> fetchMaterialsForSelectedFocus() {
            List<String> materials = new ArrayList<>();
            try {
                  connection = getConnection();
                  PreparedStatement statement = connection.prepareStatement("SELECT m.materials_name from materials m, materialstofocus mf, focus f WHERE mf.materialstofocus_materials = m.materials_id and mf.materialstofocus_focus = f.focus_id and f.focus_name = ?");
                  String selectedFocusValue = this.selectedFocusType.value;
                  statement.setString(1, selectedFocusValue);
                  ResultSet resultSet = statement.executeQuery();
                  while (resultSet.next()) { // relacja x:y
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

      public int getFocusTimeForSelectedFocus() {
            try {
                  connection = getConnection();
                  PreparedStatement statement = connection.prepareStatement("SELECT * FROM focus f, focustime ft  where f.focus_time = ft.focustime_id and f.focus_name = ?");
                  String focusName = this.selectedFocusType.value;
                  statement.setString(1, focusName);
                  ResultSet resultSet = statement.executeQuery();
                  if (resultSet.next()) { // jest tylko relacja 1: n stad musi byc tylko 1 rezultat
                        return resultSet.getInt("focustime_time");
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

      public void saveGym() {
            int trainerId = this.selectedTrainer.getId();
            int userId = this.user.id;

            try {
                  String SQL_INSERT = "INSERT INTO gym (gym_trener_id, gym_focus_id,gym_user_id) VALUES (?,?,?)";
                  connection = getConnection();
                  PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
                  preparedStatement.setInt(1, trainerId);
                  preparedStatement.setInt(2, 2);
                  preparedStatement.setInt(3, userId);
                  int row = preparedStatement.executeUpdate();
                  System.out.print("Wpisano :" + row);
            }
            catch (SQLException e) {
                  System.out.print("Wpisano :" + e);
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

      public List<String> getGyms() {
            List<String> materials = new ArrayList<>();
            try {
                  connection = getConnection();
                  PreparedStatement statement = connection.prepareStatement("SELECT m.materials_name from materials m, materialstofocus mf, focus f WHERE mf.materialstofocus_materials = m.materials_id and mf.materialstofocus_focus = f.focus_id and f.focus_name = ?");
                  String selectedFocusValue = this.selectedFocusType.value;
                  statement.setString(1, selectedFocusValue);
                  ResultSet resultSet = statement.executeQuery();
                  while (resultSet.next()) { // relacja x:y
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


      private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(settings.url, settings.user, settings.pwd);
      }
}