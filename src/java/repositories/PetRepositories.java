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


    public  void addPet(String name, int age, String img, String description, int status, String sex, String breed, String disease) throws SQLException {
        PreparedStatement petPrepared= connection.prepareStatement("INSERT INTO pets (name ,description, age,img,status,sex,breed,disease ) values ( ?,?,?,?,?,?,?,?)");
        petPrepared.setString(2,description);
        petPrepared.setInt(3,age);
        petPrepared.setString(4,img);
        petPrepared.setInt(5,status);
        petPrepared.setString(6,sex);
        petPrepared.setString(7,breed);
        petPrepared.setString(8,disease);
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
                    rs.getInt("status"),
                    rs.getString("sex"),
                    rs.getString("breed"),
                    rs.getString("disease"));
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
                    rs.getInt("status"),
                    rs.getString("sex"),
                    rs.getString("breed"),
                    rs.getString("disease"));
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
                    rs.getInt("status"),
                    rs.getString("sex"),
                    rs.getString("breed"),
                    rs.getString("disease"));
            if (rs.getInt("status") == status){
                petsList.add(pet);
            }

        }
        return petsList;
    }

    public void updatePetStatus(int petId, int status) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("UPDATE pets SET status = ? where id_pet = ?");
        ps.setInt(1, status);
        ps.setInt(2, petId);
        ps.executeUpdate();
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PetRepositories petRepositories = new PetRepositories();
        Pet dog  = petRepositories.getPetByName("Mike");
        System.out.println(dog.getName());
    }

    public List<Pet> getPetByUserId(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from pets where user_id = ?");
        preparedStatement.setInt(1, userId);
        List<Pet> pets = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Pet pet = new Pet();
            pet.setId(resultSet.getInt("id_pet"));
            pet.setDescription(resultSet.getString("description"));
            pet.setName(resultSet.getString("name"));
            pet.setAge(resultSet.getInt("age"));
            pet.setBreed(resultSet.getString("breed"));
            pet.setImg(resultSet.getString("img"));
            pets.add(pet);
        }
        return pets;
    }

    public void setPetUser(int idPet, int id_user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update pets set user_id=? where id_pet = ?");
        preparedStatement.setInt(1, id_user);
        preparedStatement.setInt(2, idPet);
        preparedStatement.executeUpdate();
    }
}
