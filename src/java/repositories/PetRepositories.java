package repositories;

import entities.Pet;
import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetRepositories {
    public Connection connection = (Connection) ConnectionDB.connect();

    public PetRepositories() throws ClassNotFoundException {
    }


    public  void addPet(String name, int age, String img, String description, int status) throws SQLException {
        PreparedStatement petPrepared= connection.prepareStatement("INSERT INTO pets (name,description, age,img ) values ( ?,?,?,?,?)");
        petPrepared.setString(1,name);
        petPrepared.setString(2,description);
        petPrepared.setInt(3,age);
        petPrepared.setString(4,img);
        petPrepared.setInt(5,status);


        System.out.println( petPrepared.executeUpdate());


    }

    public Pet getPetByName(String name) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets WHERE name = ?");
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();
        Pet pet = null;
        while (rs.next()) {
            pet = new Pet(
// public Pet(int id, String name, int age,  String description,String img)
                    rs.getInt("id_pet"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("description"),
                    rs.getString("img"),
                    rs.getInt("status"));
        }
        return pet;

    }

    public Pet getPetById(int id_pet) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets WHERE id_pet = ?");
        ps.setInt(1, id_pet);
        ResultSet rs = ps.executeQuery();
        Pet pet = null;
        while (rs.next()) {
            pet = new Pet(
                    rs.getInt("id_pet"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("description"),
                    rs.getString("img"),
                    rs.getInt("status"));
        }
        return pet;
    }

    public List<Pet> getByStatus(int status) throws SQLException{
        List<Pet> petsList = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM pets WHERE status = ?");
        ps.setInt(1,status);
        ResultSet rs = ps.executeQuery();
        Pet pet = null;
        while (rs.next()) {
            pet = new Pet(
                    rs.getInt("id_pet"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("description"),
                    rs.getString("img"),
                    rs.getInt("status"));
            if (rs.getInt("status") == status){
                petsList.add(pet);
            }

        }
        return petsList;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PetRepositories petRepositories = new PetRepositories();
        Pet dog  = petRepositories.getPetByName("Mike");
        System.out.println(dog.getName());
    }
}
