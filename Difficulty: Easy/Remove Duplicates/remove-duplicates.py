#User function Template for python3
class Solution:
	def removeDups(self, str):
	 seen = set()
	 res = []
	 for char in s:
            if char not in seen:
                seen.add(char)
                res.append(char)
     return ''.join(res)	# code here


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        s = input()

        ob = Solution()
        answer = ob.removeDups(s)

        print(answer)

# } Driver Code Ends