package repositories;

import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PetRepositories {
    public Connection connection = (Connection) ConnectionDB.connect();

    public PetRepositories() throws ClassNotFoundException {
    }


    public  void addPet(String name,boolean sex, int age, String img, String text) throws SQLException {
        PreparedStatement petPrepared= connection.prepareStatement("INSERT INTO pets (name,sex,age,img,text) values ( ?,?,?,?,?)");
        petPrepared.setString(1,name);
        petPrepared.setBoolean(2,sex);
        petPrepared.setInt(3,age);
        petPrepared.setString(4,img);
        petPrepared.setString(5,text);
        System.out.println( petPrepared.executeUpdate());


    }
}
