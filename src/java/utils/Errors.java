package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Errors {

    int errors = 0;


        public boolean isEmail(String email){
            if (email.equals("")){
                
            }
            Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
            Matcher matcher = pattern.matcher(email);
            boolean isEmail = matcher.matches();
            return isEmail;
        }

        public boolean isCorrectPasswords(String password1, String password2){
            return password1.equals(password2);
        }


}
