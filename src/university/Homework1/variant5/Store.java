package university.Homework1.variant5;

public class Store {
    private String name;

    public Store(String name) {
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
        return "Store{" +
                "name='" + name + '\'' +
                '}';
    }
}