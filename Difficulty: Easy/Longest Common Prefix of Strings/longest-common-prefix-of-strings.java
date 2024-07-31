//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
      public String findMin(String []arr){
          int maxLength = Integer.MAX_VALUE;
          String ans="";
          for(int i=0;i<arr.length;i++){
              if(arr[i].length()<=maxLength){
                  maxLength = arr[i].length();
                  ans = arr[i];
              }
          }
          return ans;
      }
    public String longestCommonPrefix(String arr[]) {
        String ans="-1";
        int maxLength = Integer.MIN_VALUE;
        String min = findMin(arr);
        int n = arr.length;
        
        int i=0;
        int count=0;
        while(i<min.length()){
            String str = min.substring(0,i+1);
            count=0;
            for(int j=0;j<n;j++){
                String str2 = arr[j].substring(0,i+1);
                if(str2.equals(str)){
                    count++;
                }
                else{
                    break;
                }
            }
            if(count==n && str.length()>maxLength){
                maxLength = str.length();
                ans=str;
            }
            i++;
        }
        return ans;  // code here
    }
}