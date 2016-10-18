package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
	//AC 3ms
   public List<Integer> grayCode(int n) {
          List<Integer> result=new ArrayList<Integer>();
          if(n==0) return result;
          result.add(0);
          result.add(1);
          if(n==1) return result;
          for(int i=2;i<n+1;i++){
        	 int curSize=result.size();
        	 for(int j=curSize;j>0;j--){
        		 result.add(result.get(j-1)+(1<<(i-1)));
        	 }
          }
          return result;
    }
   
   public static void main(String [] args){
	   GrayCode89 g=new GrayCode89();
	   List<Integer> list=g.grayCode(10);
	   for(int i=0;i<list.size();i++){
		   System.out.print(list.get(i)+" ");
	   }
   }
}
