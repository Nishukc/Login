package services;

import domain.User;
import utls.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServices {
    public User getUser(String name, String password) {
        User user = null;

        //Database query

        String query = "select * from user where name=? and password=?";
        PreparedStatement preparedStatement = new DatabaseConnection().getPreparedStatement(query);

        try {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setBookname(rs.getString("bookname"));
                user.setAuthor(rs.getString("author"));
                user.setVersion(rs.getInt("version"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        String query = "select * from user";
        PreparedStatement preparedStatement = new DatabaseConnection().getPreparedStatement(query);

        try {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setBookname(rs.getString("bookname"));
                user.setAuthor(rs.getString("Author"));
                user.setVersion(rs.getInt("version"));

                //ading user to list
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void add(User user) {
        String query = "insert into user (id, bookname, author, version) values(????)";
        PreparedStatement preparedStatement = new DatabaseConnection().getPreparedStatement(query);

        try {
            preparedStatement.setInt(1, user.getVersion());
            preparedStatement.setString(1, user.getBookname());
            preparedStatement.setString(1, user.getAuthor());

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}






