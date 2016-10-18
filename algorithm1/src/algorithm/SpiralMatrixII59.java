package algorithm;

public class SpiralMatrixII59 {
	public int[][] generateMatrix(int n) {
	       int[][] r=new int[n][n];
	       int left=0,right=n-1,top=0,bottom=n-1,count=1;
	       while(left<right&&top<bottom){
	    	  //向左
	    	   for(int i=left;i<=right;i++) r[top][i]=count++;
	    	   //向下
	    	   for(int i=top+1;i<=bottom;i++) r[i][right]=count++;
	    	   //向左
	    	   for(int i=right-1;i>=left;i--) r[bottom][i]=count++;
	    	   //向上 
	    	   for(int i=bottom-1;i>=top+1;i--) r[i][left]=count++;
	    	   left=left+1;
	    	   right=right-1;
	    	   top=top+1;
	    	   bottom=bottom-1;
	       }
	       if(left==right&&top==bottom) r[left][top]=count;
	       return r;
	    }
	
	public static void main(String[] args){
		SpiralMatrixII59 s=new SpiralMatrixII59();
		int[][] r=s.generateMatrix(4);
		for(int i=0;i<r.length;i++){
			System.out.println();
			for(int j=0;j<r[0].length;j++){
				System.out.print(r[i][j]+",");
			}
		}
	}
}
