// Problem Link: https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

// User function Template for Java

class Solution{
    static boolean findSubSetSumRecursive(int N, int arr[], int sum){
        if(N==0){
            return false;
        }
        if(sum == 0){
            return true;
        }
        if(arr[N-1]<=sum){
            return findSubSetSum(N-1, arr, sum-arr[N-1]) || findSubSetSum(N-1, arr, sum);
        } else {
             return findSubSetSum(N-1, arr, sum);
        }
    }
    
    static boolean findSubSetSum(int N, int arr[], int sum){
        boolean[][] t = new boolean[N+1][sum+1];
        
        for(int i = 0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){
                    t[i][j]=false;
                } 
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        for(int i = 1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                
                if(arr[i-1]<=j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }
                else 
                    t[i][j]= t[i-1][j];
            }
        }
        return t[N][sum];
    }
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int i = 0;i<N;i++){
            sum+=arr[i];
        }
        
        if(sum%2!=0){
            return 0;
        }
        
        // boolean bool = findSubSetSumRecursive(N, arr, sum/2);
        boolean bool = findSubSetSum(N, arr, sum/2);
        if(bool){
            return 1;
        } else 
            return 0;
    }
}
