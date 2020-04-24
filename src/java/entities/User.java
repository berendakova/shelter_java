package entities;

public class User {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String[] userRoles;
    private int idUser;
private String isSuperuser;

    public User() {
    }

    public User(int     idUser, String userName, String userEmail, String userPassword,String isSuperuser) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.isSuperuser = isSuperuser;
    }

    public String getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(String isSuperuser) {

        this.isSuperuser = isSuperuser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
