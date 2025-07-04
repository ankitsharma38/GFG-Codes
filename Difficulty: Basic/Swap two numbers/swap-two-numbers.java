import java.util.*;

class Solution {
    static List<Integer> get(int a, int b) {
        // Swapping without using a temp variable
        a = a + b;
        b = a - b;
        a = a - b;

        // Return the swapped values as a list
        List<Integer> result = new ArrayList<>();
        result.add(a);
        result.add(b);
        return result;
    }
}
