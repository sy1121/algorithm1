package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	//AC  2ms
   public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> rlist=new ArrayList<List<Integer>>();   
      backtrace(new ArrayList<Integer>(),rlist,0,n,k,0);
      return rlist;
    }
   
   public void backtrace(List<Integer> list,List<List<Integer>> rlist,int level,int n,int k,int position){
	   if(k==level){
		   rlist.add(new ArrayList<Integer>(list));
		   return ;
	   }
	   for(int i=position+1;i<n+1;i++){
		   if(i+(k-level-1)>n) break;   //¼õÖ¦
		   list.add(i);
		   backtrace(list,rlist,level+1,n,k,i);
		   list.remove(list.size()-1);
	   }
	   
   }
   
   public static void main(String[] args){
	   Combinations  c=new Combinations();
	   List<List<Integer>>  r=c.combine(1, 1);
	   System.out.println("r="+r);
   }
}
