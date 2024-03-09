package university.Homework1.variant3;

public class Dentist extends Doctor {
    private static final Dentist DENTIST = new Dentist();

    public static Dentist getInstance() {
        return DENTIST;
    }

    @Override
    protected String writeRecipe(String recipe) {
        StringBuilder builder = new StringBuilder(recipe);
        return builder.reverse().toString();
    }
}