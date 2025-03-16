//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        int startIdx=0,endIdx=arr.length-1;
        int maxIdx=0,maxSum=0;
        int minJumps=0;
        while(startIdx<=endIdx){
            int left=startIdx+1,right=startIdx+arr[startIdx];
            if(right>=endIdx) return minJumps+1;
            maxSum=0;
            for(int i=left;i<=right;i++){
                int currSum=i+arr[i];
                if(currSum>maxSum){
                    maxIdx=i;
                    maxSum=currSum;
                }
            }
            // System.out.println(maxIdx);
            if(arr[maxIdx]==0) return -1;
            startIdx=maxIdx;
            minJumps++;
        }
        
        return minJumps; // code here
        
    }
}