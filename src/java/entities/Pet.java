package entities;

public class Pet {
    private int id;
    private String name;
    private boolean sex;
    private int age;
    private String img;
    private String text;

    public Pet(int id, String name, boolean sex, int age, String img, String text) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.img = img;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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
