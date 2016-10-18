package algorithm;

import java.util.Arrays;

public class ValidSudoku36 {
	//Ac 5ms
	 public boolean isValidSudoku(char[][] board) {
	        boolean[] baseNum=new boolean[10];
	        //行
	        for(int i=0;i<9;i++){
	             Arrays.fill(baseNum,false);
	            for(int j=0;j<9;j++){
	                if(board[i][j]=='.') continue;
	                if(!baseNum[board[i][j]-'0']) baseNum[board[i][j]-'0']=true;
	                else return false;
	            }
	        }
	        //列
	         for(int i=0;i<9;i++){
	             Arrays.fill(baseNum,false);
	            for(int j=0;j<9;j++){
	                if(board[j][i]=='.') continue;
	                if(!baseNum[board[j][i]-'0']) baseNum[board[j][i]-'0']=true;
	                else return false;
	            }
	        }
	        //单元格
	        for(int i=0;i<3;i++){
	            for(int j=0;j<3;j++){
	                int dx=i*3,dy=j*3;
	                 Arrays.fill(baseNum,false);
	                for(int m=dx;m<dx+3;m++){
	                    for(int n=dy;n<dy+3;n++){
	                      if(board[m][n]=='.') continue;
	                      if(!baseNum[board[m][n]-'0']) baseNum[board[m][n]-'0']=true;
	                      else return false;
	                    }
	                }
	            }
	        }
	        return true;
	    }
	 
	 public static void main(String[] args){
		 ValidSudoku36 v=new ValidSudoku36();
		 char[][] board={{'.','8','7','6','5','4','3','2','1'},
				         {'2','.','.','.','.','.','.','.','.'},
				         {'3','.','.','.','.','.','.','.','.'},
				         {'4','.','.','.','.','.','.','.','.'},
				         {'5','.','.','.','.','.','.','.','.'},
				         {'6','.','.','.','.','.','.','.','.'},
				         {'7','.','.','.','.','.','.','.','.'},
				         {'8','.','.','.','.','.','.','.','.'},
				         {'9','.','.','.','.','.','.','.','.'}};
		 boolean r=v.isValidSudoku(board);
		 System.out.println("r="+r);
	 }
}
