package university.Homework1.variant3;

public class Therapist extends Doctor {
    private static final Therapist THERAPIST = new Therapist();

    public static Therapist getInstance() {
        return THERAPIST;
    }

    @Override
    public String writeRecipe(String recipe) {
        return "Рецепт: Спать надо больше!";
    }
}