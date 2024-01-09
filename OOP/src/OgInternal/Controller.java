package OgInternal;

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
      private FocusType focusType;

      public Controller(ConnectionSettings settings) {
            this.settings = settings;
      }

      public static Controller empty() {
            return new Controller(new ConnectionSettings());
      }

      public User getUser() {
            return user;
      }

      public void setUser(User user) {
            this.user = user;
      }

      public FocusType getFocusType() {
            return focusType;
      }

      public void setFocusType(FocusType focusType) {
            this.focusType = focusType;
      }

      public List<Trener> getTrainers() {
            return trainers;
      }

      public void setTrainers(List<Trener> trainers) {
            this.trainers = trainers;
      }

      public void fetchTrainers()  {
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
                  connection.close();
                  trainers.forEach( trener -> {
                        System.out.println(trener);

                  }  );
            }
            catch (SQLException e) {
                  e.printStackTrace();
            }
      }
}