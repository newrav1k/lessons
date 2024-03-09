package university.Homework1.variant3;

public class Therapist extends Doctor {
    private static final Therapist THERAPIST = new Therapist();

    public static Therapist getInstance() {
        return THERAPIST;
    }

    @Override
    protected String writeRecipe(String recipe) {
        return "Спать надо больше!";
    }
}