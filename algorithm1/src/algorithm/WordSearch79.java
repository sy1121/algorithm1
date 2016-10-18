package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordSearch79 {
	 static class Mychar{
		 int level;
		 char content;
		 int x;
		 int y;
	 }
	 public boolean exist(char[][] board, String word) {
	       Stack<Mychar> s=new Stack<Mychar>();
	       List<Mychar> visiteds=new ArrayList<Mychar>();  
	       int len=word.length();
	       for(int i=0;i<board.length;i++){
	    	   for(int j=0;j<board[0].length;j++){
	    		   if(board[i][j]==word.charAt(0)){
	    			   Mychar c=new Mychar();
	    			   c.content=board[i][j];
	    			   c.level=1;
	    			   c.x=i;
	    			   c.y=j;
	    			   s.push(c);
	    		   }
	    	   }
	       }
	       
	       while(!s.isEmpty()){
	    	   Mychar top=s.pop();
	    	   if(visiteds.isEmpty()||visiteds.get(visiteds.size()-1).level<top.level)
	    	   visiteds.add(top);
	    	   else{
	    		   while(!visiteds.isEmpty()&&visiteds.get(visiteds.size()-1).level>=top.level){
	    			   visiteds.remove(visiteds.size()-1);
	    		   }
	    		   visiteds.add(top);
	    	   }
	    	   
	    	   if(top.level==word.length()) return true;
	    	   //左
	    	   if(top.y-1>=0&&board[top.x][top.y-1]==word.charAt(top.level)&&!contain(visiteds,top.x,top.y-1)){
	    		   Mychar c=new Mychar();
    			   c.content=word.charAt(top.level);
    			   c.level=top.level+1;
    			   c.x=top.x;
    			   c.y=top.y-1;
    			   s.push(c);
	    	   }
	    	   //右
	    	   if(top.y+1<board[0].length&&board[top.x][top.y+1]==word.charAt(top.level)&&!contain(visiteds,top.x,top.y+1)){
	    		   Mychar c=new Mychar();
    			   c.content=word.charAt(top.level);
    			   c.level=top.level+1;
    			   c.x=top.x;
    			   c.y=top.y+1;
    			   s.push(c);
	    	   }
	    	   //上
	    	   if(top.x-1>=0&&board[top.x-1][top.y]==word.charAt(top.level)&&!contain(visiteds,top.x-1,top.y)){
	    		   Mychar c=new Mychar();
    			   c.content=word.charAt(top.level);
    			   c.level=top.level+1;
    			   c.x=top.x-1;
    			   c.y=top.y;
    			   s.push(c);
	    	   }
	    	   //下
	    	   if(top.x+1<board.length&&board[top.x+1][top.y]==word.charAt(top.level)&&!contain(visiteds,top.x+1,top.y)){
	    		   Mychar c=new Mychar();
    			   c.content=word.charAt(top.level);
    			   c.level=top.level+1;
    			   c.x=top.x+1;
    			   c.y=top.y;
    			   s.push(c);
	    	   }
	    	   
	       }
	       return false;
	    }
	 
	 public boolean contain(List<Mychar> list,int x,int y){
		   if(list==null) return false;
		   for(int i=0;i<list.size();i++){
			   if(list.get(i).x==x&&list.get(i).y==y) return true;
		   }
		   return false;
	 }
	 
	 public static void main(String[] args){
		 WordSearch79 w=new WordSearch79();
		 char[][] board={{'A','B','C','E'},
			 {'S','F','C','S'},
			 {'A','D','E','E'}};
		 String word="ABCB";
		 boolean r=w.exist(board, word);
		 System.out.println("r="+r);
	 }
}
