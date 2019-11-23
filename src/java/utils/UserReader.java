package utils;

import entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserReader {
    public List<User> readUser(String fileName) throws FileNotFoundException {
        //(String name, String email, String password, String country, String age, String bio, String gender)
//Tanyasha,razdvatree@gmail,1234567,over_13,women,Germany,loh
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        List<User> users = new ArrayList<>();
        String input;
        String[] items;
        String name;
        String email;
        String password;
        String[] roles = new String[3];

        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            items = input.split(",");
            name = items[0];
            email = items[1];
            password = items[2];
            roles[0] = items[3];
            roles[1] = items[4];
            roles[2] = items[5];
            users.add(new User(name, email, password,roles));
        }
        return users;
    }
}
