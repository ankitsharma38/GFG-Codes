//{ Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            String[] S = ob.findThePattern(N);
            
            for(int i=0; i<S.length; i++)
                System.out.println(S[i]);
        }
    }
}
// } Driver Code Ends


class Solution {
    static String[] findThePattern(int N) {
        String[] result = new String[N]; // store rows of the pattern
        char currentChar = 'A'; // Startinnn character
        
        for (int i = 0; i < N; i++) {
            StringBuilder row = new StringBuilder();
            
            if (i == 0 || i == N - 1) {
                for (int j = 0; j < N; j++) {
                    row.append(currentChar);
                    currentChar++;
                }
            } 
            else {
                row.append(currentChar); // First character of the row
                currentChar++;
                for (int j = 0; j < N - 2; j++) {
                    row.append('$'); // Add dollar signs
                }
                row.append(currentChar); // Last character of the row
                currentChar++;
            }
            
            result[i] = row.toString(); // Store the constructed row
        }
        
        return result;
    }
}