package repositories;

import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRolesRepository {

    public  Connection connection = (Connection) ConnectionDB.connect();

    public UserRolesRepository() throws ClassNotFoundException {
    }


    public  void addUserRole(int id_user, int id_role) throws SQLException {

        PreparedStatement userRolePrepared = connection.prepareStatement("INSERT INTO users_roles (id_user, id_role) values ( ?, ?)");
        userRolePrepared.setInt(1,id_user);
        userRolePrepared.setInt(2,id_role);
        System.out.println( userRolePrepared.executeUpdate());

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = (Connection) ConnectionDB.connect();
        UserRolesRepository userRolesRepository = new UserRolesRepository();
        userRolesRepository.addUserRole(10,2);
        PreparedStatement user_role_check = connection.prepareStatement("SELECT * FROM users_roles");
        ResultSet resultSet = user_role_check.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id_user"));

        }

    }


}
