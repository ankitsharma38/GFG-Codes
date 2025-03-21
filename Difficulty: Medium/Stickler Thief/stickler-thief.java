//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        
        int prev2 = 0;//we are looting two houses before
        int prev1 = arr[0];//previous huse loot
        int maxLoot = prev1;
        
        for(int i = 1; i<n; i++){
            maxLoot = Math.max(prev1, arr[i] +prev2 );
            prev2 = prev1;
            prev1 = maxLoot;
        }
        return maxLoot;
        
        
    }
}