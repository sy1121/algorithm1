package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
	//AC 1ms
	 public List<Integer> getRow(int rowIndex) {
	        List<Integer> rlist=new ArrayList<Integer>();
	        for(int i=0;i<=rowIndex;i++)
	        rlist.add(cc(rowIndex,i));
	        return rlist;
	    }
	    
	    public int cc(int a,int b){
	        if(a==b||b==0) return 1;
	        else{
	            long r=1;
	            if(a-b>b){
	            for(int i=a,j=2;i>a-b||j<=b;){
	                if(i>a-b){
	                    r=r*i;i--;
	                }
	                if(r%j==0&&j<=b){
	                    r=r/j;j++;
	                }
	            } 
	            }else{
	            for(int i=a,j=2;i>b||j<=a-b;){
	             if(i>b){
	                 r=r*i;i--;
	             }
	             if(r%j==0&&j<=a-b){
	                  r=r/j;j++;
	             }
	            }
	            }
	            return (int)r;
	        }
	    }
    
    public static void main(String[] args){
    	PascalsTriangleII119 p=new PascalsTriangleII119();
    	List<Integer>  rlist=p.getRow(30);
    	for(int i=0;i<rlist.size();i++){
    	   System.out.print(rlist.get(i)+",");
    	}
    }
}
