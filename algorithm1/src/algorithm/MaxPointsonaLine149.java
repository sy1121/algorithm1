package algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class MaxPointsonaLine149 {
	  static class  Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	  
	  //AC 28ms
	  //HashMap Hashset和边界条件的考虑 :相同的点 斜率为无穷的线 和为0的线  为0时还有考虑+0,-0 ；
	  //依次以每一个点为中心点计算它后面的点到该点的斜率 得到经过该点的直线中包括最多的点的数量 
	  //如果后后面的点和当前的点相同 则需要为所有直线包含的点数加1
   public int maxPoints(Point[] points) {
         int size=points.length,result=1,same=0;
         if(size<1) return 0;
         double k;
         HashMap<Double,Integer> map=new HashMap<Double,Integer>();
         HashSet<Point> set=new HashSet<Point>();
         for(int i=0;i<size-result;i++){
        	 Point curP;
        	 if(set.contains(points[i])) continue;
        	 else{
        	   curP=points[i];
        	   set.add(curP);
        	 }
        	 for(int j=i+1;j<size;j++){
        	   if(points[j].x==curP.x&&points[j].y==curP.y) {same++;continue;} //相同点
        	   if((points[j].x-curP.x)==0) k=Integer.MAX_VALUE; //斜率无限大
        	   else if(points[j].y-curP.y==0) k=0;  //斜率为0
        	   else k=(double)(points[j].y-curP.y)/(double)(points[j].x-curP.x);
        	   if(map.containsKey(k)) map.put(k,map.get(k)+1); //把相应的线上的点数加1
        	   else map.put(k, 2); //出现新的线
        	 }
        	 int max=0;
        	 for(double key:map.keySet()){  
        		if(map.get(key)>max) max=map.get(key);
        	  }
        	 if(same!=0)
        	 max+=same;
        	 else max+=same+1;
        	 result=Math.max(result, max);
        	 map.clear();
        	 same=0;
         }
         return result;
    }
   
   public static void main(String[] args){
	   MaxPointsonaLine149 m=new MaxPointsonaLine149();
	   Point p1=new Point(2,3);
	   Point p2=new Point(3,3);
	   Point p3=new Point(-5,3);
	   Point p4=new Point(2,2);
	   Point p5=new Point(2,2);
	   int r=m.maxPoints(new Point[]{p1,p2,p3});
	   System.out.println("r="+r);
   }
}
