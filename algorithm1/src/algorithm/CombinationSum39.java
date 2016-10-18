package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum39 {
	//AC  14ms  比较粗糙  还可以做一些减枝的操作
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<Integer> list=new ArrayList<Integer>();
		 List<List<Integer>>  rlists=new ArrayList<List<Integer>>();
		 if(candidates==null||candidates.length==0)  return rlists;
		 Arrays.sort(candidates);
		 traceback(0,list,rlists,candidates,target);
		 return rlists;
	    }
	 
	 public void traceback(int level,List<Integer> list,List<List<Integer>> rlists,int[] candidates,int target){
		  if(target==0) {
			  ArrayList<Integer> temp=new ArrayList<Integer>(list);
			  rlists.add(temp); 
			  return;
		  }
		 if(level==candidates.length){
			  return ;
		  }else{
			  int count=target/candidates[level];
			  for(int i=0;i<=count;i++){
				  addToList(list,candidates[level],i);
				  traceback(level+1,list,rlists,candidates,target-i*candidates[level]);
				  removeFromList(list,candidates[level],i);
			  }
		  }
	 }
	 
	 public void addToList(List<Integer> list,int num,int time){
		  if(time<1||list==null)  return;
		  else{
			  while(time>0){
				  list.add(num);
				  time--;
			  }
		  }
	 }
	 
	 public void removeFromList(List<Integer> list,int num,int time){
		 if(time<1||list==null)  return ;
		 else{
			 while(time>0){
				 list.remove((Integer)num);
				 time--;
			 }
		 }
	 }
	 
	 public static void main(String[] args){
		 CombinationSum39  c=new CombinationSum39();
		 int[] candidates={7,6,2,3};
		 ArrayList<List<Integer>> r=(ArrayList<List<Integer>>) c.combinationSum(candidates, 7);
		 System.out.println("r="+r);
		 
	 }
}
