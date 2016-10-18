package algorithm;

public class MaximalSquare221 {
	//AC 15ms 动态规划解法    （i，j）子矩阵可以形成的正方形有多少个正方形的1 r(i,j)
	 public int maximalSquare(char[][] matrix) {
		 if(matrix.length==0||matrix[0].length==0)  return 0; 
	        int x=matrix.length,y=matrix[0].length,max=0;
	        int[][] r=new int[x][y];
	        //初始化
	        for(int i=0;i<x;i++) {
	        	r[i][0]=matrix[i][0]-'0';
	        	if(r[i][0]>max) max=r[i][0];
	        }
	        for(int j=1;j<y;j++){
	        	r[0][j]=matrix[0][j]-'0';
	        	if(r[0][j]>max) max=r[0][j];
	        }
	        for(int i=1;i<x;i++){
	        	for(int j=1;j<y;j++){
	        		if(matrix[i][j]=='0') r[i][j]=0;
	        		else{
	        		r[i][j]=Math.min(r[i-1][j-1],Math.min(r[i-1][j],r[i][j-1]))+1;
	        		if(r[i][j]>max) max=r[i][j];
	        		}
	        	}
	        }
	       return max*max;
	    }
	 
	 public static void main(String[] agrs){
		 MaximalSquare221 m=new MaximalSquare221();
		 char[][] s={{'1','1'},{'1','1'}};
		 int r=m.maximalSquare(s);
		 System.out.println("r="+r);
	 }
}

