package university.Homework2.variant4;

public class Passport {
    private int number;
    private String name;
    private String post;
    private boolean isPassingCompleted;

    public Passport(String name, int number, String post, boolean isPassingCompleted) {
        this.name = name;
        this.number = number;
        this.post = post;
        this.isPassingCompleted = isPassingCompleted;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "%s, %d, %s, %b".formatted(name, number, post, isPassingCompleted);
    }

}