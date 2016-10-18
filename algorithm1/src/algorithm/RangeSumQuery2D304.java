package algorithm;

public class RangeSumQuery2D304 {
	//AC 7ms
    int[][] sums;
    public RangeSumQuery2D304(int[][] matrix) {
        sums=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length+1;i++) sums[i][0]=0;
        for(int j=1;j<matrix[0].length+1;j++) sums[0][j]=0;
        for(int i=1;i<matrix.length+1;i++){
            for(int j=1;j<matrix[0].length+1;j++){
                sums[i][j]=sums[i-1][j]+sums[i][j-1]-sums[i-1][j-1]+matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
         return sums[row2+1][col2+1]+sums[row1][col1]-sums[row2+1][col1]-sums[row1][col2+1];
    }
    
    public static void main(String[] args){
    	int[][] matrix={
    	                {3, 0, 1, 4, 2},
    	                {5, 6, 3, 2, 1},
    	                {1, 2, 0, 1, 5},
    	                {4, 1, 0, 1, 7},
    	                {1, 0, 3, 0, 5}
                        };
    	RangeSumQuery2D304 r=new RangeSumQuery2D304(matrix);
    	int result=r.sumRegion(2, 1, 4, 3);
    	System.out.println("result="+result);
    }
}
