// Problem Link: https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/0

//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        // recursive solution 
        // if(sum==0)
        //     return true;
        // if(N==0)
        //     return false;
        
        // if(arr[N-1] <=sum){
        //     return isSubsetSum(N-1, arr, sum - arr[N-1]) || isSubsetSum(N-1, arr, sum);
        // } else {
        //     return isSubsetSum(N-1, arr, sum);
        // }
        
        // DP
        Boolean [][] t = new Boolean[N+1][sum+1];
        
        for(int i =0; i<=N;i++){
            for(int j =0; j<=sum;j++){
                if(j==0) 
                    t[i][j]=true;
                else if(i==0) 
                    t[i][j]=false;
                else if(arr[i-1] <=j) {
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                 else {
                    t[i][j] = t[i-1][j];
                 }
            }
        }
        return t[N][sum];
        
    }
}
