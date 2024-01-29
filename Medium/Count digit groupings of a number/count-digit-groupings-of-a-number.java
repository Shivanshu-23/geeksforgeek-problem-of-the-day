//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.TotalCount(str);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalCount(String str)
    {
         // Get the length of the input string
        int n = str.length();
        
        // Initialize a 2D array for dynamic programming
        // dp[idx][prev] stores the result for substring starting from idx with the previous sum 'prev'
        int[][] dp = new int[n][1000];
        
        // Initialize the dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Call the recursive solve method to calculate the total count
        return solve(str, 0, 0, dp);
    }
        
        private int solve(String str, int idx, int prev, int[][] dp) {
        // If the end of the string is reached, return 1
        if (idx == str.length()) {
            return 1;
        }
        
        // If the result for the current index and previous sum is already calculated, return it
        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }
        
        int ans = 0;
        int sum = 0;
        
        // Iterate over the substring starting from the current index
        for (int i = idx; i < str.length(); i++) {
            // Update the sum by adding the current digit
            sum += (str.charAt(i) - '0');
            
            // If the updated sum is greater than or equal to the previous sum, recursively call solve
            ans += (sum >= prev) ? solve(str, i + 1, sum, dp) : 0;
        }
        
        // Memoize the result and return it
        return dp[idx][prev] = ans;
}
}