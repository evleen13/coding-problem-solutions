/* 
        1. brute force:
        traverse through the matrix, if current element is 0 then mark all the 1s in the row and column to be -1.
        Once this is done, replace all the -1s with 0. 
        The time complexity would be O(n*m) * O(n+m) + O(n*m) = O(n^3)
*/

class Solution {
    public void markRow(int m, int n, int [][] matrix) {
			for(int i = 0; i<n;i++) {
				if(matrix[m][i] != 0) {
					matrix[m][i]=-1;
				}
			}
    }
    public void markColumn(int n, int m, int [][] matrix) {
			for(int i = 0; i<m;i++) {
				if(matrix[i][n]!=0) {
					matrix[i][n]=-1;
				}
			}
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m;i++){
					for(int j=0; j<n;j++){
						if(matrix[i][j]==0){
							markRow(i,n, matrix);
							markColumn(j,m, matrix);
						}
					}
        }

        for(int i = 0; i<m;i++){
          for(int j=0; j<n;j++){
            if(matrix[i][j] == -1){
              matrix[i][j]=0;
            }
          }
        }

    }
}

