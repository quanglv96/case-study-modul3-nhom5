package DAO;

import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;
    private final String SELECT_ALL_USER = "select * from user;";
    private final String SELECT_USER_BY_ID = "select * from user where id_user = ?;";
    private final String INSERT_USER = "insert into user(username_user,password,phoneNumber_user,email_user,address_user,status_user) value(?,?,?,?,?,?);";
    private final String UPDATE_USER = "update user set username_user = ?, password = ?, phoneNumber_user = ?,email_user = ?, address_user = ?, status_user = ? where id_user = ?;";
    private final String DELETE_USER = "delete from user where id_user = ?;";

    public UserDAO() {
        connection = MyConnection.getConnection();
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER)) {
            getListUsers(users, preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void getListUsers(List<User> users, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int idUser = Integer.parseInt(resultSet.getString("id_user"));
            String userName = resultSet.getString("username_user");
            String password = resultSet.getString("password");
            String phoneNumber = resultSet.getString("phoneNumber_user");
            String email = resultSet.getString("email_user");
            String address = resultSet.getString("address_user");
            int statusUser = Integer.parseInt(resultSet.getString("status_user"));
            users.add(new User(idUser, userName, password, phoneNumber, email, address, statusUser));
        }
    }

    public User findUserById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String userName = resultSet.getString("username_user");
                String password = resultSet.getString("password");
                String phoneNumber = resultSet.getString("phoneNumber_user");
                String email = resultSet.getString("email_user");
                String address = resultSet.getString("address_user");
                int statusUser = resultSet.getInt("status_user");
                return new User(id, userName, password, phoneNumber, email, address, statusUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void insertUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getStatusUser());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void upDateUser(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhoneNumber());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setInt(6, user.getStatusUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteUser(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

