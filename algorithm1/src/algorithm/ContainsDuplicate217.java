package algorithm;

import java.util.HashSet;

public class ContainsDuplicate217 {
	
	//AC  15ms
/*	  public boolean containsDuplicate(int[] nums) {
	        HashSet<Integer> set=new HashSet<Integer>();
	        int size=nums.length; 
	        for(int i=0;i<size;i++){
	        	if(set.contains(nums[i]))  return false;
	        	else  set.add(nums[i]);
	        }
	        return  true;
	    }*/
	
	  public boolean containsDuplicate(int[] nums) {
		  boolean[] a=new boolean[Integer.MAX_VALUE-1];
		  int size=nums.length ;
		  for(int i=0;i<size;i++){
			  if(a[nums[i]]==false)
			  a[nums[i]]=true;
			  else
				 return true;
		  }
		  return false;
	  }
	  
	  public static void main(String[] args){
		  ContainsDuplicate217 c=new ContainsDuplicate217();
		  int[] nums={1,2,3,4,5354,3453453,35345,35,6,5,4};
		  boolean r=c.containsDuplicate(nums);
		  System.out.println("r="+r);
	  }
}
