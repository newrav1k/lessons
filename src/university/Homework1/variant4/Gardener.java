package university.Homework1.variant4;

public class Gardener {
    public void filter(Plant plant) {
        String name = plant.getName()
                .replaceAll("[eyuioa]", "") + "VGTBL";
        plant.setName(name);
    }
}