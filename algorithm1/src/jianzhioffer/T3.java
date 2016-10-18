package jianzhioffer;

public class T3 {
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int xlen=matrix.length,ylen=matrix[0].length;
	        int up=0,right=ylen-1;
	        while(up<xlen&&right>=0){
	           if(matrix[up][right]==target) return true;
	           else if(matrix[up][right]<target) up++;
	           else right--;
	        }
	        return false;
	    }
}
