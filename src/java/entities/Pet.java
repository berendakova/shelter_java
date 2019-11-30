package entities;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String img;
    private String description;
    private int status;
    private String sex;
    private String breed;
    private String disease;

    public Pet(int id, String name, int age,  String description,String img, int status, String sex, String breed, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.img = img;
        this.description = description;
        this.status = status;
        this.sex = sex;
        this.breed = breed;
        this. disease = disease;
    }

    public Pet() {

    }

    public int getStatus() {
        return status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
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
