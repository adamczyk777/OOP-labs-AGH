package pl.edu.agh.student.jakubada.crossword.dictionary;

public class Entry {
    private String clue;
    private String word;

    public Entry(String clue, String word) {
        this.clue = clue;
        this.word = word;
    }

    public String getClue() {
        return clue;
    }

    public String getWord() {
        return word;
    }
}
