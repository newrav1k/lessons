package university.Homework1.variant2;

public class Seller {
    public void modify(Telephone telephone) {
        String name = telephone.getName();
        if (name.startsWith("N") || name.startsWith("n")) {
            name = name.replaceAll("o", "a");
        } else {
            name = name.toLowerCase().replaceAll("o", "a");
        }
        telephone.setName(name);
    }
}