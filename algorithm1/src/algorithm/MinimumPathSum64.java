package algorithm;

public class MinimumPathSum64 {
	//AC 4ms  动态规划
	/*public int minPathSum(int[][] grid) {
	    int xlen=grid.length;
	    if(xlen<1) return 0;
	    int ylen=grid[0].length;
	    int[][] sum=new int[xlen][ylen];
	    sum[0][0]=grid[0][0];
	    for(int i=1;i<xlen;i++){
	    	sum[i][0]=sum[i-1][0]+grid[i][0];
	    }
	    for(int j=1;j<ylen;j++){
	    	sum[0][j]=sum[0][j-1]+grid[0][j];
	    }
	    for(int i=1;i<xlen;i++){
	    	for(int j=1;j<ylen;j++){
	    		sum[i][j]=Math.min(sum[i-1][j], sum[i][j-1])+grid[i][j];
	    	}
	    }
	    return sum[xlen-1][ylen-1];
    }*/
	//AC 2ms 记忆化搜索 
	public int minPathSum(int[][] grid) {
    int xlen=grid.length;
    if(xlen<1) return 0;
    int ylen=grid[0].length;
    return resur(xlen-1,ylen-1,new int[xlen][ylen],grid);
}

   public int resur(int i,int j,int[][] mem,int[][] grid){
	if(i==0&&j==0) return grid[0][0];
	if(mem[i][j]!=0) return mem[i][j];
	int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
	if(i>0) up=resur(i-1,j,mem,grid);
	if(j>0) left=resur(i,j-1,mem,grid);
	int t=Math.min(up, left)+grid[i][j];
	mem[i][j]=t;
	return t;
    }
}
