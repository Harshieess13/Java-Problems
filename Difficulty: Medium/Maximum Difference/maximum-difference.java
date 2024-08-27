//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
         int left[]=new int[arr.length];
       int right[]=new int[arr.length];
       
      int i=0,j=1;
      Stack<Integer> st=new Stack<>();
      while(i<arr.length && j<arr.length){
          
          if(arr[i]<=arr[j]){
              st.push(i);
              i++;
              j++;
          }
          else{
              right[i]=arr[j];
              while(st.size()>0 && arr[st.peek()]>arr[j]){
                  right[st.pop()]=arr[j];
            
              }
              
                  i=j;
                  j++;
             
          }
          
      }
      
      i=arr.length-1;
      j=arr.length-2;
      st=new Stack<>();
       while(i>=0  && j>=0){
          
          if(arr[i]<=arr[j]){
              st.push(i);
              i--;
              j--;
          }
          else{
              left[i]=arr[j];
                while(st.size()>0 && arr[st.peek()]>arr[j]){
                  left[st.pop()]=arr[j];
            
              }
                  i=j;
                  j--;
              
          }
          
      }
      
      int max=0;
      for(int k=0;k<arr.length;k++){
         max=Math.max(max,Math.abs(left[k]-right[k])) ;
      }
      return max;  // code here
    }
}
