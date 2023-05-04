package Task_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("File3.txt");
        //Якщо коректно вказати шлях до файлу то все працює
       try {
           wordsCounter(file);
       }catch (FileNotFoundException e){
           System.out.println("File not found");
       }
    }
    private static void wordsCounter(File file) throws FileNotFoundException {
        Map<String, Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String word = scanner.next();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        scanner.close();
        Map<Integer, String> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        for (String word : map.keySet()) {
            int freq = map.get(word);
            String wordsWithSameFrequency = sortedMap.getOrDefault(freq, "");
            sortedMap.put(freq, wordsWithSameFrequency + word + " ");
        }
        for (int freq : sortedMap.keySet()) {
            String str = sortedMap.get(freq);
            System.out.println(str.trim() + " " + freq);
        }
    }
}

