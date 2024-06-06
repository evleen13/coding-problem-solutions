// Link-  https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

class Solution
{
    public boolean[][] isSubSetSum(int arr[], int n, int sumOfArray, boolean[][] subsetMatrix){
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sumOfArray; j++){
                if(j==0) 
                    subsetMatrix[i][j]=true;
                else if(i==0) 
                    subsetMatrix[i][j]=false;
                else if(arr[i-1]<=j){
                    subsetMatrix[i][j]= subsetMatrix[i-1][j-arr[i-1]] || subsetMatrix[i-1][j];
                }
                else {
                    subsetMatrix[i][j] = subsetMatrix[i-1][j];
                }
            }
        }
        return subsetMatrix;
    }
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sumOfArray = 0;
	    for(int i=0;i<n;i++){
	        sumOfArray+=arr[i];
	    }
	    // find subset sum with sum=range
	    boolean[][] subsetMatrix = new boolean[n+1][sumOfArray+1];
	    subsetMatrix = isSubSetSum(arr, n, sumOfArray, subsetMatrix);
	   
	    // traverse over last row in the array till range/2 and put value in a new array wherever there is true
	    List<Integer> sumPossibleArray = new ArrayList<Integer>();
	    for(int i = 0; i<=sumOfArray/2;i++){
	        if(subsetMatrix[n][i]==true){
	            sumPossibleArray.add(i);
	        }
	    }

	    // traverse over sumPossible array and find min of range - 2*sumPossible[i]
	    int min= Integer.MAX_VALUE;
	    for(int i=0;i<sumPossibleArray.size();i++){
	        min = Math.min(min, sumOfArray - 2 * sumPossibleArray.get(i));
	    }
	  	return min;
	}
}
