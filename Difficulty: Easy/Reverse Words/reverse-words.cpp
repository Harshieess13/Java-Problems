//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to reverse words in a given string.
    string reverseWords(string str) {
      stack<string> s;
        
        string temp = "";
        
        for(int i = 0; i < str.size(); i++){
            if(str[i] != '.'){
                temp += str[i];
            }
            if(str[i] == '.' || (i == str.size()-1)){
                s.push(temp);
                temp = "";
            }
        }
        
        string result = "";
        
        while(!s.empty()){
            result += s.top();
            s.pop();
            if(!s.empty()){
                result += '.';
            }
        }
        
        return result;   // code here
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.reverseWords(s) << endl;
    }
}
// } Driver Code Ends