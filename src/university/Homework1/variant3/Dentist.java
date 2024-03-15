package university.Homework1.variant3;

public class Dentist extends Doctor {
    @Override
    public String writeRecipe(String recipe) {
        StringBuilder builder = new StringBuilder(recipe);
        return String.format("Рецепт: %s", builder.reverse());
    }
}