package npr.puzzle;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Dictionary dict = new Dictionary();
        String fileName = "dictionary.txt";
        FileWriter file = new FileWriter(fileName);
        for (String word: dict.getWords()) {
            StringBuilder seqName = new StringBuilder(word).deleteCharAt(5).deleteCharAt(2);
            file.write(String.format("%s\t%s\n", word, seqName));
        }
        file.close();
    }
}
