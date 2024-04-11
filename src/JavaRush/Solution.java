package JavaRush;

/*
Вперёд в будущее
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) return false;
        if (o == null || this == null) return false;
        if (o == this) return true;
        return (this.last != null && ((Solution) o).last != null && this.last.equals(((Solution) o).last) && this.first.equals(((Solution) o).first));
    }

    @Override
    public int hashCode() {
        return 31 * (first != null ? first.hashCode() : 0) + (last != null ? last.hashCode() : 0);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}