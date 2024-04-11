package game.CrossAndZero;

public enum Figure {
    Cross,
    Zero;

    public String getFigure() {
        return this.ordinal() == 0 ? "X" : "O";
    }
}