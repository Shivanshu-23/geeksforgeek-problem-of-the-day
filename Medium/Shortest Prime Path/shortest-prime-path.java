//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution {
    // Array to store whether a number is prime or not
    int[] prime;

    // Constructor to initialize the prime array
    Solution() {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
        prime = new int[10000];
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;

        // Sieve of Eratosthenes algorithm to mark non-prime numbers
        for (int i = 2; i * i <= 10000; i++) {
            for (int j = 2; i * j < 10000; j++) {
                prime[i * j] = 0;
            }
        }

        // Setting values to 0 for indices less than 1000
        for (int i = 0; i < 1000; i++) {
            prime[i] = 0;
        }
    }

    // Function to find the shortest path between two prime numbers
    int solve(int num1, int num2) {
        // Queue for BFS traversal
        Queue<int[]> que = new LinkedList<>();
        // Array to mark visited numbers
        int[] arr = new int[10000];
        // Adding the starting number to the queue
        que.add(new int[]{num1, 0});
        // Marking the starting number as visited
        arr[num1] = 1;

        // BFS traversal
        while (!que.isEmpty()) {
            // Dequeue the current number
            int[] a = que.poll();
            // If the current number is equal to the target, return the steps
            if (a[0] == num2) return a[1];

            // Generating next numbers in the sequence
            for (int i = 1; i <= 1000; i *= 10) {
                for (int j = 0; j <= 9; j++) {
                    // Calculate the next number in the sequence
                    int k = a[0] / (i * 10);
                    k *= (i * 10);
                    k += (j * i);
                    k += a[0] % i;
                    // If the next number is prime and not visited, mark it as visited and enqueue
                    if (k < 10000 && prime[k] == 1 && arr[k] == 0) {
                        arr[k] = 1;
                        que.add(new int[]{k, a[1] + 1});
                    }
                }
            }
        }
        // If the target number is not reached, return -1
        return -1;
    }
}


//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends