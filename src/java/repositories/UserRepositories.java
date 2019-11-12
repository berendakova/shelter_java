package repositories;

import entities.User;
import exceptions.DbException;
import exceptions.DuplicateEntryException;
import utils.DB;

import java.util.List;

public class UserRepositories {
    public static void add(User user) throws DbException, DuplicateEntryException {
        // Find duplicates and throw DuplicateEntryException if found
        // Add new entry otherwise
        // throw new DuplicateEntryException();
        DB.addEntry("users", new String[]{user.getUser_name(),user.getUser_email(),user.getUser_password()});
    }
    public static List<UserRepositories> getAll(){
        // Use Db.getAllEntries and make List<User> from List<String[]> - Repository works with entities
        // Return real List here
        return null;
    }
}