//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String digits = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countWays(digits);
            out.println(ans);

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countWays(String digits) {
        if (digits == null || digits.length() == 0 || digits.charAt(0) == '0') 
            return 0;
        
        int n = digits.length();
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty string can be decoded in 1 way
        dp[1] = digits.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(digits.substring(i - 1, i));  // Last one digit
            int twoDigits = Integer.parseInt(digits.substring(i - 2, i)); // Last two digits
            
            if (oneDigit >= 1) 
                dp[i] += dp[i - 1]; // Single digit decoding
            
            if (twoDigits >= 10 && twoDigits <= 26) 
                dp[i] += dp[i - 2]; // Two digit decoding
        }
        
        return dp[n];
    }
}
