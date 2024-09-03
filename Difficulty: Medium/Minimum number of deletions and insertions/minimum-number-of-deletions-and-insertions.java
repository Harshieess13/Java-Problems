//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int lcs(int i,int j,String s,String t,int dp[][]) {
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)) {
            return 1+lcs(i-1,j-1,s,t,dp);
        }
        
        int i_reduce = lcs(i-1,j,s,t,dp);
        int j_reduce = lcs(i,j-1,s,t,dp);
        
        return dp[i][j] = Math.max(i_reduce,j_reduce);
    }
    public int minOperations(String s, String t) 
    { 
       
        int m = s.length();
        int n = t.length();
        int dp[][] = new int[m][n];
        for(int row[] : dp) Arrays.fill(row,-1);
        
        int common_substring = lcs(m-1,n-1,s,t,dp);
        
        int remove = m - common_substring;
        int add = n - common_substring;
        
        return remove+add;
    } 
}