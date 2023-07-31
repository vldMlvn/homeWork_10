package word_frequency_counter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordFrequencyCounter {

    public static void main(String[] args) {

        File file = new File("src/main/java/word_frequency_counter/text_exempl.txt");

        try {
            wordsCounter(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static void wordsCounter(File file) throws FileNotFoundException {

        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        scanner.close();

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}