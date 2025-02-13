package Day2_Collections.Set_Interface;

import java.util.HashSet;
import java.util.Set;

public class FindSubset {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Adding elements to set1
        set1.add(2);
        set1.add(3);

        // Adding elements to set2
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);

        // Print the result
        System.out.println("Is Set1 a subset of Set2? :" + isSubset);
    }
}
