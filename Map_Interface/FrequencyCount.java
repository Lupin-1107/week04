package Day2_Collections.Map_Interface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCount {
    // Method to count word frequencies from the given file
    public static Map<String, Integer> countWordFrequencies(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        try {
            // Read the file
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                // Split the line into words
                String[] words = line.split("\\s+");

                // Update word counts in the map
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCountMap;
    }

    public static void main(String[] args) {
        String filePath = "input.txt";

        // Count word frequencies
        Map<String, Integer> wordFrequencies = countWordFrequencies(filePath);

        // Print the word frequencies
        System.out.println(wordFrequencies);
    }
}
