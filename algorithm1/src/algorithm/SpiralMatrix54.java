package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
	//AC 1ms  根据模拟走的过程，每次更具当前的条件判断，下步走到哪 ，直到全部走完
	/*private int dir=1,xlen,ylen,xindex=0,yindex=0;;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
         xlen=matrix.length;
        if(xlen==0) return result;
         ylen=matrix[0].length;
        boolean[][] visited=new boolean[xlen][ylen];
        for(int i=0;i<xlen;i++){
        	for(int j=0;j<ylen;j++){
        		visited[i][j]=false;
        	}
        }
        int xindex=0,yindex=0;
        Integer next=matrix[0][0];
        result.add(next);
        visited[0][0]=true;
        while((next=getNext(matrix,visited))!=null){
            result.add(next);
        }
        return result;
    }
    
    private Integer getNext(int[][] matrix,boolean[][] visited){   
    	  if(dir==1){  //向右
              if(yindex+1<ylen&&!visited[xindex][yindex+1]){
            	  yindex+=1;
              }else {
            	  dir=-2;
            	  xindex+=1;
            	  if(xindex>=xlen||visited[xindex][yindex]){
            		  return null;
            	  }
              }
           }else if(dir==-2){ //向下
                 if(xindex+1<xlen&&!visited[xindex+1][yindex]){
                	 xindex+=1;
                 }else{
                	 dir=-1;
                	 yindex-=1;
                	 if(yindex<0||visited[xindex][yindex]){
                		 return null;
                	 }
                 }
               
           }else if(dir==-1){//向左
                 if(yindex-1>=0&&!visited[xindex][yindex-1]){
                	yindex-=1;
                 }else{
                	 dir=2;
                	 xindex-=1;
                	 if(xindex<0||visited[xindex][yindex]) return null;
                 }
               
           }else{//向上
                if(xindex-1>=0&&!visited[xindex-1][yindex]){
                    xindex-=1;
                    visited[xindex][yindex]=true;
                }else{
                	 dir=1;
                	 yindex=yindex+1;
                	 if(yindex>=ylen||visited[xindex][yindex]) return null;
                }
               
           }
    	  visited[xindex][yindex]=true;
    	  return matrix[xindex][yindex];
    }*/
	//AC 0ms
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
    	int xlen=matrix.length;
        if(xlen==0) return result;
        int ylen=matrix[0].length;
        int left=0,up=0,right=ylen-1,down=xlen-1;
        while(left<right&&up<down){
        	//向右
        	for(int i=left;i<=right;i++) result.add(matrix[up][i]);
            //向下
        	for(int i=up+1;i<=down;i++) result.add(matrix[i][right]);
        	//向左
        	for(int i=right-1;i>=left;i--) result.add(matrix[down][i]);
        	//向上
        	for(int i=down-1;i>up;i--) result.add(matrix[i][left]);
            left=left+1;
            up=up+1;
            right=right-1;
            down=down-1;
        }
        if(left==right&&up==down) result.add(matrix[left][up]);
        else if(left!=right&&up==down){
        	for(int i=left;i<=right;i++) result.add(matrix[up][i]);
        }else if(left==right&&up!=down){
        	for(int i=up;i<=down;i++) result.add(matrix[i][left]);
        }
        return result;
        	
    }
    
    public static void main(String[] args){
    	int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	SpiralMatrix54 s=new SpiralMatrix54();
    	List<Integer>  list=s.spiralOrder(matrix);
    	for(int i=0;i<list.size();i++){
    		System.out.print(list.get(i)+",");
    	}
    }
}
