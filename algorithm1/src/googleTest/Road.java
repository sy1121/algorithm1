package googleTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Road {
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()){
			int n = cin.nextInt();
			int m=cin.nextInt();
			boolean[][] sign=new boolean[n][m];
			for(int i=0;i<n;i++)
			Arrays.fill(sign[i], true);
			int[] ns=new int[n-1];
			int[] ms=new int[m-1];
			for(int i=0;i<n-1;i++) ns[i]=cin.nextInt();
			for(int i=0;i<m-1;i++) ms[i]=cin.nextInt();
			int k=cin.nextInt();
			for(int i=0;i<k;i++)
				sign[cin.nextInt()-1][cin.nextInt()-1]=false;
			int caseCount=cin.nextInt();
			for(int i=0;i<caseCount;i++){
				int startx=cin.nextInt();
				int starty=cin.nextInt();
				int endx=cin.nextInt();
				int endy=cin.nextInt();
                Point startP=new Point();
                Point endP=new Point();
                startP.x=startx-1;
                startP.y=starty-1;
                endP.x=endx-1;
                endP.y=endy-1;
                Queue<Point> q=new LinkedList<Point>();
                q.add(startP);
                bfs(q,ns,ms,sign,endP);
                System.out.println(result);
			}
		}
		
 }
	
    private static void bfs(Queue<Point> q,int[] ns,int[] ms,boolean[][] sign,Point endP){
    	while(!q.isEmpty()){
    		Point cur=q.poll();
    	    //左 
    		if(cur.y>0&&sign[cur.x][cur.y-1]) {
    			Point p=new Point(cur.x,cur.y-1);
    			p.value=cur.value+ms[cur.y-1];
    			if(p.equals(endP)){
    				if(result>p.value) result=p.value;
    			}else{
    			   for(Point point:q){
    				   if(point.equals(p)&&p.value<point.value){
    					   point.value=p.value;
    				   }
    			   }
    			   
    			   q.add(p);
    			}
    		}
    		//右
    		if(cur.y<sign[0].length-1&&sign[cur.x][cur.y+1]){
    			Point p=new Point(cur.x,cur.y+1);
    			p.value=cur.value+ms[cur.y];
    			if(p.equals(endP)){
    				if(result>p.value) result=p.value;
    			}else{
    			   for(Point point:q){
    				   if(point.equals(p)&&p.value<point.value){
    					   point.value=p.value;
    				   }
    			   }
    			   q.add(p);
    			}
    		}
    		//上
    		if(cur.x>0&&sign[cur.x-1][cur.y]) {
    			Point p=new Point(cur.x-1,cur.y);
    			p.value=cur.value+ns[cur.x-1];
    			if(p.equals(endP)){
    				if(result>p.value) result=p.value;
    			}else{
    			   for(Point point:q){
    				   if(point.equals(p)&&p.value<point.value){
    					   point.value=p.value;
    				   }
    			   }
    			   q.add(p);
    			}
    		}
    		//下
    		if(cur.x<sign.length-1&&sign[cur.x+1][cur.y]) {
    			Point p=new Point(cur.x+1,cur.y);
    			p.value=cur.value+ns[cur.x];
    			if(p.equals(endP)){
    				if(result>p.value) result=p.value;
    			}else{
    			   for(Point point:q){
    				   if(point.equals(p)&&p.value<point.value){
    					   point.value=p.value;
    				   }
    			   }
    			   q.add(p);
    			}
    		}
    		sign[cur.x][cur.y]=false;
    	}
    }
    
    public static class Point{
    	public int x;
    	public int y;
    	public int value=0;
    	public Point(){
    		
    	}
    	public Point(int x,int y){
    		this.x=x;
    		this.y=y;
    	}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Point p=(Point)obj;
			if(this.x==p.x&&this.y==p.y)
			return true;
			else return false;
		}
    	
    }
}



