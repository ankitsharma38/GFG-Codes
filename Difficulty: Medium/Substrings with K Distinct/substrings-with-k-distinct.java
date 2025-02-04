//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            System.out.println(new Solution().countSubstr(s, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    int countSubstr(String s, int k) {
        return atMost(s, k) - atMost(s, k - 1);
    }
    
    private int atMost(String s, int k) {
        int n = s.length();
        int count = 0;      
        int left = 0;     
        int distinct = 0;   
        
        int[] freq = new int[26];
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq[c - 'a']++;
            if (freq[c - 'a'] == 1) {
                distinct++;
            }
            
            while (distinct > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                if (freq[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}