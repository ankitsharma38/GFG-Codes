//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int n = mat.length;

        // Step 1: Initializing two pointers
        int candidate = 0;

        // Step 2: Finding the candidate for celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i; // candidate knows i, so candidate cannot be a celebrity, i might be
            }
        }

        // Step 3: Verifying if the candidate is actually a celebrity
        for (int i = 0; i < n; i++) {
            // candidate should not know any person
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }

        // candidate is the celebrity
        return candidate;
    }
}