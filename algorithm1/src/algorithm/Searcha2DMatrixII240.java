package algorithm;

public class Searcha2DMatrixII240 {
	//14ms O(nlogn)
  /* public boolean searchMatrix(int[][] matrix, int target) {
        int xlen=matrix.length,ylen=matrix[0].length;
        int startRow=0,endRow=xlen-1;
        for(int i=0;i<xlen;i++){
        	if(matrix[i][0]>target){
        		endRow=i-1;
        		break;
        	}
        }
        for(int i=0;i<xlen;i++){
        	if(matrix[i][ylen-1]>=target){
        		startRow=i;
        		break;
        	}
        }
        
        for(int i=startRow;i<=endRow;i++){
        	if(binarySearch(matrix[i],target)) return true;
        }
        return false;
    }
   
   private boolean binarySearch(int[] num,int target){
	     int len=num.length,left=0,right=len-1,mid;
	     while(left+1<right){
	    	 mid=(left+right)/2;
	    	 if(num[mid]>target) right=mid;
	    	 else if(num[mid]<target) left=mid;
	    	 else return true;
	     }
	     if(num[left]==target||num[right]==target) return true;
	     else return false;
   }*/
	//好方法 O(m+n) 从矩阵的右上角开始，比较与target的大小，每次去掉一行或一列 所以最多只需要m+n步
	 public boolean searchMatrix(int[][] matrix, int target) {
	        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
	            return false;
	        }
	        int col = matrix[0].length-1;
	        int row = 0;
	        while(col >= 0 && row <= matrix.length-1) {
	            if(target == matrix[row][col]) {
	                return true;
	            } else if(target < matrix[row][col]) {
	                col--;
	            } else if(target > matrix[row][col]) {
	                row++;
	            }
	        }
	        return false;
	    }
   public static void main(String[] args){
	   Searcha2DMatrixII240 s=new Searcha2DMatrixII240();
	   int[][] matrix={{5},{6}};
	   boolean r=s.searchMatrix(matrix, 6);
	   System.out.println("r="+r);
   }
}
