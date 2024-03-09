package university.Homework2.variant1;

public class Car {
    private String name;
    private int year;
    private String number;

    public Car(String name, int year, String number) {
        this.name = name;
        this.year = year;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "%s, %d, %s".formatted(name, year, number);
    }
}