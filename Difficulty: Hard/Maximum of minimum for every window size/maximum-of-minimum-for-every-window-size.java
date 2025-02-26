//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String line = sc.nextLine();
            String[] input = line.split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            Solution solution = new Solution();
            ArrayList<Integer> result = solution.maxOfMins(arr);
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends



class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
                int n = arr.length;
        int[] left = new int[n];  // Previous Smaller Element Index
        int[] right = new int[n]; // Next Smaller Element Index
        int[] result = new int[n + 1];

        Stack<Integer> stack = new Stack<>();

        // Initialize NSE and PSE
        Arrays.fill(left, -1);
        Arrays.fill(right, n);

        // Find Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        // Find Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        // Compute Maximum of Minimums for each Window Size
        for (int i = 0; i < n; i++) {
            int windowSize = right[i] - left[i] - 1;
            result[windowSize] = Math.max(result[windowSize], arr[i]);
        }

        // Fill Missing Values
        for (int i = n - 1; i >= 1; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        // Convert result to ArrayList
        ArrayList<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            resList.add(result[i]);
        }

        return resList;
    }
}

