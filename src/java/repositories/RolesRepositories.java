package repositories;

import entities.User;
import entities.UserRole;
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

    public UserRole getRolesByName(String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM roles WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        UserRole role = null;
        while (rs.next()) {
            role = new UserRole(
                    rs.getInt("id"),
                    rs.getString("name"));
        }
        return role;

    }
    public  void addRoles(String name) throws SQLException {
        PreparedStatement userPrepared= connection.prepareStatement("INSERT INTO roles (name) values ( ?)");
        userPrepared.setString(1,name);
        System.out.println( userPrepared.executeUpdate());

    }


}
