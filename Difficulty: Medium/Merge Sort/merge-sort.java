//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    // Function to merge the two halves
    void merge(int arr[], int l, int m, int r)
    {
         int i, j, k;
         int n1 = m - l + 1;
         int n2 = r - m;

         // Create temporary arrays
         int L[] = new int[n1];
         int R[] = new int[n2];
         
         // Copy data to temporary arrays L[] and R[]
         for (i = 0; i < n1; i++)
             L[i] = arr[l + i];
         for (j = 0; j < n2; j++)
             R[j] = arr[m + 1 + j];
         
         // Merge the temporary arrays back into arr[l..r]
         i = 0; // Initial index of first subarray
         j = 0; // Initial index of second subarray
         k = l; // Initial index of merged subarray
         
         while (i < n1 && j < n2) {
             if (L[i] <= R[j]) {
                 arr[k] = L[i];
                 i++;
             }
             else {
                 arr[k] = R[j];
                 j++;
             }
             k++;
         }
         
         // Copy the remaining elements of L[], if any
         while (i < n1) {
             arr[k] = L[i];
             i++;
             k++;
         }
         
         // Copy the remaining elements of R[], if any
         while (j < n2) {
             arr[k] = R[j];
             j++;
             k++;
         }
    }

    // Function to sort array arr[] using merge sort algorithm
    void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}