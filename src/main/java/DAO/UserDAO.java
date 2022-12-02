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
    private final String SELECT_ALL_USER="select * from user;";
    private final String SELECT_USER_BY_ID="select * from user where id_user = ?;";

    public UserDAO(){
        connection=MyConnection.getConnection();
    }
    public List<User> findAll(){
        List<User>users=new ArrayList<>();
        try (
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USER)){
            getListUsers(users,preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    private void getListUsers(List<User> users, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            int idUser=Integer.parseInt(resultSet.getString("id_user"));
            String userName=resultSet.getString("username_user");
            String password=resultSet.getString("password");
            String phoneNumber=resultSet.getString("phoneNumber_user");
            String email=resultSet.getString("email_user");
            String address=resultSet.getString("address_user");
            int statusUser =Integer.parseInt(resultSet.getString("status_user"));
            users.add(new User(idUser,userName,password,phoneNumber,email,address,statusUser));
        }
    }
}
