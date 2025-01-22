//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    // Function returns the second
    // largest elements
    int getSecondLargest(vector<int> &arr) {
        int max = arr[0];
        int secondLargest = -1;
        
        for(int i=1; i<arr.size(); i++){
            if(arr[i] > max)
            {
                secondLargest = max;
                max = arr[i];
            }
            else if(arr[i] > secondLargest && arr[i] < max)
            {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
};
//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution ob;
        int ans = ob.getSecondLargest(arr);
        cout << ans << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends