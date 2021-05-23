package npr.puzzle;

public class PuzzleFilter {
    public boolean passes(String word) {
        return word.length() == 8 &&
                word.charAt(2) == 'a' &&
                word.charAt(5) == 'a' &&
                word.matches("^[a-z]*$");
    }
}
