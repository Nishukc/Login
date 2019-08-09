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
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));

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
                user.setName(rs.getString("Name"));
                user.setAddress(rs.getString("Address"));
                user.setPassword(rs.getString("Password"));

                //adding user to list
                userList.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void add(User user) {
        String query = "insert into user (id, name, address, password) values(????)";
        PreparedStatement preparedStatement = new DatabaseConnection().getPreparedStatement(query);

        try {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
        }

//test test test test test test test test test test tes testetststs
    }

}






