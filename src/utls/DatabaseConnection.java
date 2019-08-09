package utls;

import java.sql.*;

public class DatabaseConnection {
    String url = "jdbc:mysl://localhost:3306/demo";
    String name = "root";
    String password ="";

    Connection connection = null;

    public DatabaseConnection(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url,name,password);
            System.out.println("Database Connected");
    }
        catch (SQLException e){
            e.printStackTrace();
        }
         catch (ClassNotFoundException ex){
            ex.printStackTrace();
         }
        }

        public PreparedStatement getPreparedStatement(String query){
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement(query);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pst;
        }
}
