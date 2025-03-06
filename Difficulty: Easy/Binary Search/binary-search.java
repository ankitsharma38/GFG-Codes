//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// this code not passes after 10 case in gfg but it conrrect run on netflix

// class Solution {
//     public int binarysearch(int[] arr, int k) {
//         int left = 0;
//         int right = arr.length - 1;
        
//         while(left <= right) {
//             int mid = left + (right - left) / 2;
//             if(arr[mid] == k) {
//                 return mid;
//             } else if(arr[mid] < k) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int binarysearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == k) {
                ans = mid;         
                right = mid - 1;   
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}

