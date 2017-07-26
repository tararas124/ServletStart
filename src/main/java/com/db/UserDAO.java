package com.db;

import entity.Item;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by taras on 13.06.2017.
 */
public enum UserDAO {
    INSTANCE;

    public void insertItem(Item item) {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            String sql = "insert into item(text, state, userID) values (?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, item.getText());
            pstm.setInt(2, item.getState());
            pstm.setInt(3, item.getUserID());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            String sql = "INSERT into user(name, age, address, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, user.getName());
            pstm.setInt(2, user.getAge());
            pstm.setString(3, user.getAddress());
            pstm.setString(4, user.getPassword());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String userName) {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            String sql = "SELECT a.name, a.age, a.address, a.password from user a where a.name = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, userName);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setName(userName);
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Item> getItems(int userID) {
        String sql = "SELECT a.itemID, a.text, a.state FROM item a where userID = ?";

        List<Item> list = new ArrayList<>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, userID);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String text = rs.getString("text");
                int state = rs.getInt("state");
                int id = rs.getInt("itemID");
                list.add(new Item(id, text, state, userID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteItem(String itemId) {
        String sql = "delete from item where itemID = ?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, itemId);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUser(String name, String password) {

        String sql = "select a.userID, a.age, a.address from user a where a.name = ? and a.password = ?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setName(name);
                user.setAddress(rs.getString("address"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User findUser(String name, int age, String address) {
        String sql = "select a.password from user a where a.name = ? and a.age = ? and a.address = ?";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setInt(2, age);
            pstm.setString(3, address);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setPassword(rs.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
