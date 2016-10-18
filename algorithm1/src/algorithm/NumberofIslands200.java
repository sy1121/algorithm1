package algorithm;

import java.util.Arrays;

public class NumberofIslands200 {
	//AC 4ms
   public int numIslands(char[][] grid) {
	   int result=0;
       int xlen=grid.length,ylen=grid[0].length; 
	   boolean[][] visited=new boolean[xlen][ylen];
	   for(int i=0;i<xlen;i++)
        Arrays.fill(visited[i], false);
        for(int i=0;i<xlen;i++){
        	for(int j=0;j<ylen;j++){
        		if(grid[i][j]=='0') continue;
        		else{
        			if(!visited[i][j]){
        				result++;
        				visit(grid,i,j,visited);
        			}
        		}
        	}
        }
        return result;
    }
   
   public void visit(char[][] grid,int i,int j,boolean[][] visited){
	   visited[i][j]=true;
	   if(i-1>=0&&grid[i-1][j]=='1'&&visited[i-1][j]==false) visit(grid,i-1,j,visited);
	   if(j-1>=0&&grid[i][j-1]=='1'&&visited[i][j-1]==false) visit(grid,i,j-1,visited);
	   if(i+1<grid.length&&grid[i+1][j]=='1'&&visited[i+1][j]==false) visit(grid,i+1,j,visited);
	   if(j+1<grid[0].length&&grid[i][j+1]=='1'&&visited[i][j+1]==false) visit(grid,i,j+1,visited);
   }
   
   public static void main(String[] args){
	   NumberofIslands200 n=new NumberofIslands200();
	   char[][] grid={{'1','0','0','1','0'},
			          {'0','0','1','0','1'},
			          {'0','1','0','1','0'},
			          {'1','1','1','0','1'}};
	   int r=n.numIslands(grid);
	   System.out.println("r="+r);
   }
}
