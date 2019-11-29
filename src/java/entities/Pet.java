package entities;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String img;
    private String description;
    private int status;

    public Pet(int id, String name, int age,  String description,String img, int status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        this.description = description;
        this.status = status;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
