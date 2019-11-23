package utils;

import entities.User;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Errors {


    public String isEmail(String email) {
        if (email.equals(" ")) {
            return null;
        } else {
            String ans = null;
            Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
            Matcher matcher = pattern.matcher(email);
            boolean isEmail = matcher.matches();

            if (isEmail) {
                ans = "true";
            }
            if (!isEmail) {
                ans = "false";
            }
            return ans;
        }
    }


    public String isCorrectPasswords(String password1, String password2)
    {
        String answ;

        if(password1.equals(password2) & password1.length()>=6){
            answ = "true";
        }
        else if (password1.length()<6){
            answ = "pass must > 6";
        }
        else {
            answ = "pass not eq";
        }
        return answ;

    }

    public boolean  existEmailInBd(String email, String password) throws FileNotFoundException {
        System.out.println("123");
        UserReader userReader = new UserReader();
        List<User> users = userReader.readUser("/home/tanya/IdeaProjects/shelter_v3/user.csv");
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUser_email());
            if((users.get(i).getUser_email().equals(email)) && (users.get(i).getUser_password().equals(password))){
                return true;
            }
        }
        return false;
    }
}
