package npr.puzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Dictionary {

    String githubUri = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";
    ArrayList<String> words = new ArrayList<>();

    public Dictionary() {
        try{
            URL url = new URL(githubUri);
            readWords(url);
        } catch (java.io.IOException err) {
            System.out.println(err.getMessage());
            System.exit(1);
        }
    }

    private void readWords(URL url) throws IOException {
        InputStream input = url.openStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        PuzzleFilter filter = new PuzzleFilter();
        while((line = reader.readLine()) != null) {
            if (filter.passes(line)) {
                words.add(line.strip());
            }
        }
        input.close();
    }

    public ArrayList<String> getWords() {
        return words;
    }
}
