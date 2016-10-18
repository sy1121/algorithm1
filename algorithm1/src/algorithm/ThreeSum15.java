package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
	
	//AC 20ms
   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();   
	   //先排序
	   Arrays.sort(nums);
	   //先选中一个元素，转化为2sum问题
	   int preValue;
	   for(int i=0;i<nums.length-2;i++){
		 if(i>0&&nums[i]==nums[i-1]) continue;
         List<List<Integer>> lists=twoSum(nums,i+1,-nums[i]);
		 for(List<Integer> list:lists){
			 list.add(0,nums[i]);
			 result.add(list);
		 }
	   }
	   return result;
    }
   
   public List<List<Integer>> twoSum(int[] nums,int start,int target){
	    List<List<Integer>> result=new ArrayList<List<Integer>>();
	   int left=start,right=nums.length-1;
	   while(left<right){
		  if(nums[left]+nums[right]<target) left++;
		  else if(nums[left]+nums[right]>target) right--;
		  else{
			  List<Integer> list=new ArrayList<Integer>();
			  list.add(nums[left++]);
			  list.add(nums[right--]);
			  if(!result.contains(list))
			  result.add(list);
		  }
	   }
	   return  result;
   }
   
   public static void main(String [] args){
	   ThreeSum15 t=new ThreeSum15();
	   int[] nums={-1,0,1,2,-1,-4};
	   List<List<Integer>> list=t.threeSum(nums);
	   for(int i=0;i<list.size();i++){
		   System.out.print("(");
		   for(int j=0;j<list.get(0).size();j++){
			   System.out.print(list.get(i).get(j)+",");
		   }
		   System.out.println(")");
	   }
   }
}
