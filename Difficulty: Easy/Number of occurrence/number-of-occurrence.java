//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int firstoccur(int[] arr,int target){
        int l=0;int r=arr.length-1;
        int fo=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target){
                fo=mid;
                r=mid-1;
            }
            else if(arr[mid]<target){
                l=mid+1;
            }else{
                r = mid-1;
            }
        }
        return fo;
    }
    
    int lastoccur(int[] arr,int target){
        int l=0;int r=arr.length-1;int lo=-1;
        
        while(l<=r){
            int mid = l +(r-l)/2;
            if(arr[mid]==target){
                lo=mid;
                l=mid+1;
            }
            else if(arr[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return lo;
    }
    int countFreq(int[] arr, int target) {
        // code here
        int first = firstoccur(arr,target);
        int last = lastoccur(arr,target);
        
        if(first ==-1 || last==-1){
            return 0;
        }
        
        return last-first+1;
    }
}
