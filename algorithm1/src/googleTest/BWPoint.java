package googleTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BWPoint {
  public static void main(String[] args){
	    Scanner cin = new Scanner(System.in);
		while (cin.hasNext()){
		    int casec = cin.nextInt();
			int bcount=cin.nextInt();
			int wcount=cin.nextInt();
		    List<Point> blist=new ArrayList<Point>(); 
		    List<Point> wlist=new ArrayList<Point>(); 
		    for(int i=0;i<bcount;i++){
		    	Point temp=new Point(cin.nextInt(),cin.nextInt());
		        blist.add(temp);
		    }
		    for(int i=0;i<wcount;i++){
		    	Point temp=new Point(cin.nextInt(),cin.nextInt());
		        blist.add(temp);
		    }
            System.out.println(match(wlist,blist));
		}
	      return ;
  }
	
	
   public static int match(List<Point> w,List<Point> b){
	           Collections.sort(w,new Point.PointComparatorByXAC());
	           Collections.sort(b,new Point.PointComparatorByXAC());
	           int pp=0;
	           
	           for(int i=w.size()-1;i>=0;i--)
	           {
	        	   Point gpp=new Point(-32768,-32768);
	               for(int j=b.size()-1;j>=0;j--)
	               {
	            	   Point mb=(Point)b.get(j);
	            	   Point mw=(Point)w.get(i);
	                   if(mb.getX()<mw.getX())
	                   {
	                       break;
	                   }
	                   if(mb.getY()<mw.getY())
	                   {
	                       continue;
	                   }
	                   if(gpp.getY()==-32768)
	                   {
	                      gpp=mb;
	                   }
	                   else
	                   {
	                       if(gpp.getY()<mb.getY())
	                       {
	                           gpp=mb;
	                       }
	                   }
	               }
	               if(gpp.getY()!=-32768)
	               {
	                   pp++;
	               }
	           }
	           return pp;
	      }
   
}

class Point{
	   private int x;
	   private int y;
	   public Point(int x,int y){
		   this.x=x;
		   this.y=y;
	   }
	   
	   public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public static class PointComparatorByXAC implements Comparator{

		@Override
		public int compare(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			Point p1=(Point)arg0;
			Point p2=(Point)arg1;
			int result=(p1.getX()>p2.getX())?1:(p1.getX()==p2.getX()?0:-1);
			return result;
		}
		   
	 }

	
	  public static class PointComparatorByYDESC implements Comparator{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Point p1=(Point)o1;
			Point p2=(Point)o2;
			int result=(p1.getY()<p2.getY())?1:(p1.getY()==p2.getX()?0:-1);
			return result;
		}
		  
	  }
}
