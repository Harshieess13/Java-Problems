//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// The functions should be written in a way that array become sorted
// in increasing order when heapSort() is called.

class Solution {
      private:
    void heapify(vector<int> &arr, int i, int size){
        int largest= i;
        int left= 2*i+1;
        int right= 2*i+2;
        if(left< size and arr[left]> arr[largest]){
            largest= left;
        }
        if(right< size and arr[largest]< arr[right]){
            largest= right;
        }
        if(largest!=i){
            swap(arr[i], arr[largest]);
            heapify(arr, largest, size);
        }
    }
    void performHeapSort(vector<int> &arr, int size){
        int n= size-1;
        while(n>0){
            swap(arr[n], arr[0]);
            heapify(arr, 0, n);
            n--;
        }
    }
  public:
    // Function to sort an array using Heap Sort.
    void heapSort(vector<int>& arr) {
       int size= arr.size();
       for (int i= size/2-1; i>=0; i--){
           heapify(arr, i, size);
           
       }
       performHeapSort(arr, size);  // code here
    }
};


//{ Driver Code Starts.

int main() {
    string ts;
    getline(cin, ts);
    int t = stoi(ts);
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution obj;
        obj.heapSort(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        // cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends