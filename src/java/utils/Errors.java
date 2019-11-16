package utils;

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
            answ = "correct";
        }
        else if (password1.length()<6){
            answ = "pass must > 6";
        }
        else {
            answ = "pass not eq";
        }
        return answ;

    }
}
