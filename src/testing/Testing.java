package testing;



public class Testing {
    public static void main(String[] args) {
        Dog dog = new Dog("Popi");
        System.out.println(dog);
        dog.setName("dobi");
        System.out.println(dog);
    }
}

class Dog {
    private String name; // переменная объекта

    public Dog(String name) { // обязаны назвать собаку
        this.name = name; // был null стал popi
    }

    public void setName(String name) { // меняет имя собаки
        this.name = name; // метод меняющий имя popi на dobi
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}