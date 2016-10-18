package jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * @author sy
 *
 */
public class T20 {
    public void printMatrix(int[][] matrix){
    	 int xlen=matrix.length,ylen=matrix[0].length;
    	 int left=0,right=ylen-1,up=0,down=xlen-1;
    	 List<Integer> rlist=new ArrayList<Integer>();
    	 while(left<right&&up<right){
    		 //向右
    		 for(int i=left;i<=right;i++) rlist.add(matrix[up][i]);
    		 //向下
    		 for(int i=up+1;i<=down;i++) rlist.add(matrix[i][right]);
    		 //向左
    		 for(int i=right-1;i>=left;i--) rlist.add(matrix[down][i]);
    		 //向上
    		 for(int i=down-1;i>up;i--) rlist.add(matrix[i][left]);
    		 up++;
    		 down--;
    		 left++;
    		 right--;
    	 }
    	 if(left==right&&up==down) rlist.add(matrix[left][up]);
    	 for(int i:rlist){
    		 System.out.print(i+" ");
    	 }
    }
    
    public static void main(String[] args){
    	T20 t=new T20();
    	int[][] matrix={{1,2,3},{5,6,7},{9,10,11}};
        t.printMatrix(matrix);
    }
}
