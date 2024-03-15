package university.Homework1.variant3;

public class Therapist extends Doctor {
        @Override
    public String writeRecipe(String recipe) {
        return String.format("Рецепт: Не \"%s\", а спать надо больше!", recipe);
    }
}