package repositories;

import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.ConnectionDB;
import utils.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositories {
    public  Connection connection = (Connection) ConnectionDB.connect();

    public UserRepositories() throws ClassNotFoundException {
    }

    public static void add(User user) throws DbException, DuplicateEntryException, ClassNotFoundException, SQLException {

        Connection connection = (Connection) ConnectionDB.connect();
        UserRepositories userRepository = new UserRepositories();
        userRepository.addUser(user.getUser_name(),user.getUser_email(),user.getUser_password());
        PreparedStatement user_check = connection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = user_check.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("name"));

        }

    }

    public  void addUser(String name,String email, String password) throws SQLException {
        PreparedStatement userPrepared= connection.prepareStatement("INSERT INTO users (name, email, password) values ( ?, ?, ?)");
        userPrepared.setString(1,name);
        userPrepared.setString(2,email);
        userPrepared.setString(3,password);
        System.out.println( userPrepared.executeUpdate());

    }


    public User getUserById(int id_user) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setInt(1, id_user);
        ResultSet rs = ps.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"));
        }
        return user;

    }

    public User getUserByLogin(String login) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
        ps.setString(1, login);
        ResultSet rs = ps.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password"));
        }
        return user;

    }



    private static User getUserByResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("password")
        );
    }

}