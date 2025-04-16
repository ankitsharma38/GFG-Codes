//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    static int evenlyDivides(int n) {
        int OgNo = n;
        int ans = 0;
        
        while(n>0){
            int lastDigit = n%10;
            if(lastDigit!=0 && OgNo % lastDigit ==0){
                ans++;
            }
            n=n/10;
        }
        return ans;
    }
}