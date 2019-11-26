package repositories;

import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RolesRepositories {
    public Connection connection = (Connection) ConnectionDB.connect();

    public RolesRepositories() throws ClassNotFoundException {
    }

    public static void add(String role) throws DbException, DuplicateEntryException, ClassNotFoundException, SQLException {

        RolesRepositories rolesRepositories = new RolesRepositories();
        rolesRepositories.addRoles(role);

      /*  PreparedStatement user_check = connection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = user_check.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("name"));

        }*/

    }
    public  void addRoles(String name) throws SQLException {
        PreparedStatement userPrepared= connection.prepareStatement("INSERT INTO roles (name) values ( ?)");
        userPrepared.setString(1,name);
        System.out.println( userPrepared.executeUpdate());

    }


}
