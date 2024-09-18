//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
       Deque<Character> st = new ArrayDeque<>();
        
        for(int i=0;i<x.length();i++){
            char c = x.charAt(i);
            
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }else{
                if(st.isEmpty()==true){
                    return false;
                }else if(!isMatching(st.peek(),c)){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    
    static boolean isMatching(char a,char b){
        if(a=='(' && b==')'){
            return true;
        }else if(a=='[' && b==']'){
            return true;
        }else if(a=='{' && b=='}'){
            return true;
        }
        return false;  // add your code here
    }
}
