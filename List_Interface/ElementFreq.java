package Day2_Collections.List_Interface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementFreq {

        public static Map<String, Integer> countFrequency(List<String> list) {
            Map<String, Integer> frequencyMap = new HashMap<>();


            for (String item : list) {
                frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
            }

            return frequencyMap;
        }

        public static void main(String[] args) {
            // input list
            List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");

            // Get the frequency map
            Map<String, Integer> frequency = countFrequency(inputList);


            System.out.println(frequency);
        }
    }



