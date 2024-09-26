//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
      int len = str.length();
        int [] lps = new int[len];
        int pre=0;
        int suf=1;
        while(suf < len){
            if(str.charAt(pre) == str.charAt(suf)){
                pre++;
                lps[suf] = pre;
                suf++;
            }else{
                if(pre==0){
                    lps[suf] =0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }
        }
        // System.out.println();
        // for(int i=0; i<len; i++) System.out.print(lps[i]+" ");
        return lps[len-1];  // code here
    }
}