package algorithm;

public class GameofLife289 {
	//AC 2ms 考虑边界，上边界和下边界 x,y方向多要考虑
	/* public void gameOfLife(int[][] board) {
	         int[][] temp=new int[board.length][board[0].length];
	      //拷贝一份
	         for(int i=0;i<board.length;i++){
	        	 for(int j=0;j<board[0].length;j++){
	        		 temp[i][j]=board[i][j];
	        	 }
	         }
	         for(int i=0;i<board.length;i++){
	        	 for(int j=0;j<board[0].length;j++){
	        	     board[i][j]=doCell(temp,i,j);
	        	 }
	         }
	         
	    }
	 
	 public int doCell(int[][] temp,int i,int j){
		 int liveCount=0; 
		 int xIndex=temp.length-1,yIndex=temp[0].length-1;
		 if(temp[i][j]==1){
			 //上面一行
			  if(i-1>=0&&j-1>=0&&temp[i-1][j-1]==1) liveCount++;
			  if(i-1>=0&&temp[i-1][j]==1) liveCount++;
			  if(i-1>=0&&j+1<=yIndex&&temp[i-1][j+1]==1) liveCount++;
			  //中间一行
			  if(j-1>=0&&temp[i][j-1]==1) {
				  liveCount++;
				  if(liveCount>3) return 0;
			  }
			  if(j+1<=yIndex&&temp[i][j+1]==1) {
				  liveCount++;
				  if(liveCount>3) return 0;
			  }
			  //下面一行
			  if(i+1<=xIndex&&j-1>=0&&temp[i+1][j-1]==1) {
				  liveCount++;
				  if(liveCount>3) return 0;
			  }
			  if(i+1<=xIndex&&temp[i+1][j]==1) {
				  liveCount++;
				  if(liveCount>3) return 0;
			  }
			  if(i+1<=xIndex&&j+1<=yIndex&&temp[i+1][j+1]==1) {
				  liveCount++;
				  if(liveCount>3) return 0;
			  }
			  if(liveCount<2) return 0;
			  else if(liveCount>=2&&liveCount<=3) return 1;
			  else  return 0;
		  }else{
			  //上面一行
			  if(i-1>=0&&j-1>=0&&temp[i-1][j-1]==1) liveCount++;
			  if(i-1>=0&&temp[i-1][j]==1) liveCount++;
			  if(i-1>=0&&j+1<=yIndex&&temp[i-1][j+1]==1) liveCount++;
			  //中间
			  if(j-1>=0&&temp[i][j-1]==1) liveCount++;
			  if(j+1<=yIndex&&temp[i][j+1]==1) liveCount++;
			  //下面
			  if(i+1<=xIndex&&j-1>=0&&temp[i+1][j-1]==1)  liveCount++;
			  if(i+1<=xIndex&&temp[i+1][j]==1) liveCount++;
			  if(i+1<=xIndex&&j+1<=yIndex&&temp[i+1][j+1]==1) liveCount++;
			  
			  if(liveCount==3)  return 1;
			  else return 0;
				   
		  }
	 }*/
	
	//别人的方法非常好，值得学习 ，怎么把代码写的精短
	// use the 1st bit to represent next generation 
	// use the 2nd bit to present current generation

	        public void gameOfLife(int[][] board) {
	            int rows=board.length;
	            int cols=board[0].length;
	            for(int i=0;i<rows;++i){
	                for(int j=0;j<cols;++j){
	                    int neighbors = getNeighbour(board, i, j);
	                    if(board[i][j]==1){
	                        if(neighbors==2 || neighbors==3)
	                            board[i][j]=3;   //用两个位来表示，精妙 ！
	                    }else{
	                        if(neighbors==3)
	                            board[i][j]=2;
	                    }
	                }
	            }    
	            for(int i=0;i<rows;++i){
	                for(int j=0;j<cols;++j){
	                    board[i][j]>>=1;
	                }
	            }
	        }

	        private int getNeighbour(int[][] board, int row, int col){
	            int cnt=0;
	            for(int i=row-1;i<=row+1;++i){
	                for(int j=col-1;j<=col+1;++j){   //怎么处理，避免了做大量的if-else判断
	                    if(i>=0 && i<board.length && j>=0 && j<board[0].length){
	                        cnt += board[i][j]&1;
	                    }
	                }
	            }
	            cnt-=board[row][col]&1;  //去掉自身的
	            return cnt;
	        }
	 
	
	 public static void main(String[] args){
		 GameofLife289 g=new GameofLife289();
		 int[][] board={{1,0,0},{1,1,1},{0,0,1}};
		 g.gameOfLife(board);
		 
		 System.out.println("[ ");
		 for(int i=0;i<board.length;i++){
			 System.out.print("[");
			 for(int j=0;j<board[0].length;j++){
				 System.out.print(board[i][j]+",");
			 }
			 System.out.println("]");
		 }
		 System.out.println("]");
	 }
}
