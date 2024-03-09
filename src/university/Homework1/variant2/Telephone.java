package university.Homework1.variant2;

public class Telephone {
    private String name;

    public Telephone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "name='" + name + '\'' +
                '}';
    }
}