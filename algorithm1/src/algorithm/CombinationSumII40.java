package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CombinationSumII40 {
	
	//AC  86ms
/*    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<Integer> list=new ArrayList<Integer>();
		 List<List<Integer>>  rlists=new ArrayList<List<Integer>>();
		 if(candidates==null||candidates.length==0)  return rlists;
		 Arrays.sort(candidates);
		 traceback(0,list,rlists,candidates,target);
		 return rlists;
	    }
	 
	 public void traceback(int level,List<Integer> list,List<List<Integer>> rlists,int[] candidates,int target){
		 if(target<0)  return ; 
		 if(target==0) {
			  ArrayList<Integer> temp=new ArrayList<Integer>(list);
			  if(!rlists.contains(temp))
			  rlists.add(temp); 
			  return;
		  }
		 if(level==candidates.length){
			  return ;
		  }else{
			  int[] choose={0,1};
			  for(int i=0;i<2;i++){
				  if(choose[i]==1)
				  list.add(candidates[level]);
				  traceback(level+1,list,rlists,candidates,target-choose[i]*candidates[level]);
				  if(choose[i]==1)
				  list.remove((Integer)candidates[level]);
			  }
		  }
	 }*/
	
	
	//AC 60ms
  /*  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	List<Integer> list=new ArrayList<Integer>();
		 List<List<Integer>>  rlists=new ArrayList<List<Integer>>();
		 HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		 if(candidates==null||candidates.length==0)  return rlists;
		 Arrays.sort(candidates);
		 //初始化map
		 for(int i=0;i<candidates.length ;i++){
			 Integer temp=map.get(candidates[i]);
			 if(temp==null) 
				 map.put(candidates[i], 1);
			 else
				 map.put(candidates[i], temp+1);
		 }
		 traceback(list,rlists,map,target);
		 return rlists;
	    }
	 
	 public void traceback(List<Integer> list,List<List<Integer>> rlists,HashMap<Integer,Integer> candidates,int target){
		 if(target<0)  return ; 
		 if(target==0) {
			  ArrayList<Integer> temp=new ArrayList<Integer>(list);
			  if(!rlists.contains(temp))
			  rlists.add(temp); 
			  return;
		  }
 	        List<Integer> clist=new ArrayList<Integer>();
 	        int pre=-1;
 	        if(list==null||list.size()==0) pre=-1;
 	        else pre=list.get(list.size()-1);
			  int count=constructCandidates(pre,candidates,clist);
			  for(int i=0;i<count;i++){
				  list.add(clist.get(i));
				  remove(candidates,clist.get(i));
				  traceback(list,rlists,candidates,target-clist.get(i));
				  list.remove(clist.get(i));
				  add(candidates,clist.get(i));
			  }
		  }
	 
	 public int constructCandidates(Integer pre,HashMap<Integer,Integer> map,List<Integer> clist){
		 int count=0;    
		 Iterator it=map.entrySet().iterator();
		      while(it.hasNext()){
		    	  Map.Entry<Integer,Integer> entity=(Map.Entry<Integer,Integer>)it.next();
		    	  int temp=entity.getKey();
		    	  if(temp>=pre){
		    	   clist.add(temp);
		    	   count++;
		    	  }
		      }
		      return count;
	 }
	 
	 public void remove(HashMap<Integer,Integer> map,Integer i){
		  Integer temp=map.get(i);
		  if(temp==null){
			  return ;
		  }else if(temp==1){
			  map.remove(i);
		  }else{
			  map.put(i, temp-1);
		  }
			  
	 }
	 
	 public void add(HashMap<Integer,Integer> map,Integer i){
		  Integer temp=map.get(i);
		  if(temp==null){
			   map.put(i, 1);
		  }
		  else 
			  map.put(i, temp+1);
	 }*/
	// 网上找的比较好的解法 AC 5ms 比较简洁  去重和减枝做得好  好好学学
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (candidates == null || candidates.length == 0){
	            return res;
	        }

	        Arrays.sort(candidates);
	        helper (res, new ArrayList<Integer>(), candidates, target,0,0);
	        return res;
	    }

	    public void helper (List<List<Integer>> res, List<Integer> ls, int[] candidates, int target, int sum, int pos){
	        if (sum == target){
	            res.add(new ArrayList<Integer>(ls));
	            return;
	        }

	        for (int i = pos; i < candidates.length; i++){
	            if (sum + candidates[i] > target){   //这里的减枝也做得好
	                break;
	            }
	            if (i != pos && candidates[i] == candidates[i-1]){  //出掉重复
	                continue;
	            }
	            ls.add(candidates[i]);
	            helper(res, ls, candidates, target, sum+candidates[i], i+1);
	            ls.remove(ls.size() - 1);
	        }
	    }
	 
	 public static void main(String[] args){
		 CombinationSumII40  c=new CombinationSumII40();
		 int[] candidates={10,1,2,7,6,1,5};
		 ArrayList<List<Integer>> r=(ArrayList<List<Integer>>) c.combinationSum2(candidates, 8);
		 System.out.println("r="+r);
		 
	 }
}
