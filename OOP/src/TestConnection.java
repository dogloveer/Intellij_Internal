import javax.xml.transform.Result;
import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String url= "jdbc:mysql://127.0.0.1:3306/oginternal?serverTimezone=UTC";
        String user="root";
        String pwd="root";

        try {
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement stat = con.createStatement();
            ResultSet result= stat.executeQuery("select * from username");
            while(result.next()){
                System.out.println(result.getString("username_name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
