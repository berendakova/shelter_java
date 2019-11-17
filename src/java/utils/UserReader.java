package utils;

import entities.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserReader {
    public  List<User> readUser(String fileName) throws FileNotFoundException {
        //(String name, String email, String password, String country, String age, String bio, String gender)
//Tanyasha,razdvatree@gmail,1234567,over_13,women,Germany,loh
        File file = new File(fileName);

        Scanner scanner = new Scanner(file);
        List<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] items = input.split(",");
            String name = items[0];
            String email = items[1];
            String password = items[2];
            users.add(new User(
                    name,email,password
            ));


        }
        return users;
    }
}
