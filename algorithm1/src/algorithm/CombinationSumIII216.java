package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
	//AC 1ms
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rlist=new ArrayList<List<Integer>>();
        backtrace(rlist,new ArrayList<Integer>(),k,0,0,n,0);
        return rlist;
    }
    
    public void backtrace(List<List<Integer>> rlist,List<Integer> list,int k,int level,int sum,int target,int position){
    	if(level==k){
    		if(sum==target)
    		rlist.add(new ArrayList<Integer>(list));
            return ;
    	}
        for(int i=position+1;i<=9;i++){
        	if(sum+i>target) break;
        	list.add(i);
        	backtrace(rlist,list,k,level+1,sum+i,target,i);
        	list.remove(list.size()-1);
        }
    }
    
    public static void main(String[] args){
    	CombinationSumIII216 c=new CombinationSumIII216();
    	List<List<Integer>>  r=new ArrayList<List<Integer>>();
    	r=c.combinationSum3(2, 6);
    	System.out.println("r="+r);
    }
}
