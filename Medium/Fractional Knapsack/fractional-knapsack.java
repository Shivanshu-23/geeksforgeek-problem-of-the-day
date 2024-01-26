//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.6f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
// Definition of the Item class with two attributes: value and weight.
class Item {
    int value, weight;
    // Constructor to initialize the values of an Item object.
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
         // Sorting the items based on their value-to-weight ratio in descending order.
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                if ((double) a.value / a.weight < (double) b.value / b.weight) return -1;
                else if ((double) a.value / a.weight > (double) b.value / b.weight) return 1;
                return 0;
            }
        });

        // Initializing the total value variable.
        double ans = 0;
        
        // Iterating through the sorted items to fill the knapsack.
        for (int i = n - 1; i >= 0; i--) {
            if (W >= arr[i].weight) {
                // If the entire item can be added, add its value to the total.
                ans += arr[i].value;
                W -= arr[i].weight;
            } else {
                // If the entire item cannot be added, add the fractional part.
                double oneUnit = (double) arr[i].value / arr[i].weight;
                ans += (double) oneUnit * W;
                return ans; // Return the total value after adding the fractional part.
            }
        }
        return ans; // Return the total value in the knapsack
    }
}