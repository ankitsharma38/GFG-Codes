//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    long floorSqrt(long n) {
        if (n == 0 || n == 1) {
            return n;
        }
        
        long left = 1, right = n, ans = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (mid * mid == n) {
                return mid;
            }
            
            if (mid * mid < n) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;   
    }
}
