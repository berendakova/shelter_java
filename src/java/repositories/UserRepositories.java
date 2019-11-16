package repositories;

import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.DB;

import java.util.List;

public class UserRepositories {
    public static void add(User user) throws DbException, DuplicateEntryException {
        System.out.println("NAME" + user.getUser_name());

        DB.addEntry("users",
                new String[]
                        {
                             user.getUser_name(),
                             user.getUser_email(),
                             user.getUser_password()
                        }
        );
    }
    public static List<UserRepositories> getAll(){

        return null;
    }
}