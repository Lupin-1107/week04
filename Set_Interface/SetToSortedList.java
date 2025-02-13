package Day2_Collections.Set_Interface;

import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        // Example HashSet
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Convert the HashSet to a sorted List using TreeSet
        Set<Integer> sortedSet = new TreeSet<>(set);

        // Convert the sorted set to a List
        List<Integer> sortedList = new ArrayList<>(sortedSet);

        // Print the result
        System.out.println("Sorted List: " + sortedList);
    }
}
