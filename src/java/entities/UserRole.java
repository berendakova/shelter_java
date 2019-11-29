package entities;

public class UserRole {

    private String name;
    private int id;

    public UserRole(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }



}
