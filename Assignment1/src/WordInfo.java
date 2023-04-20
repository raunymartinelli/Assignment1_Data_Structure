import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// This class represents a word and its meaning
class WordInfo {
    private String word;
    private String meaning;

    public WordInfo(String word, String meaning) {
        this.word = word.toLowerCase();
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return word + ": " + meaning;
    }
}
