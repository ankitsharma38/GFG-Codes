//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int countFreq(int[] arr, int target) {
        // Find the first occurrence of the target
        int first = findFirst(arr, target);
        // If target is not present, return 0
        if (first == -1) {
            return 0;
        }
        // Find the last occurrence of the target
        int last = findLast(arr, target);
        // Return the count of occurrences
        return last - first + 1;
    }

    int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1, first = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevent overflow
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1; // Search on the left side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1, last = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Prevent overflow
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1; // Search on the right side
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
}

