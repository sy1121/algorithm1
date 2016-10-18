package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElement162 {
   public int findPeakElement(int[] nums) {
        return findPeakElementRange(nums,0,nums.length-1).get(1);
    }
   
   public List<Integer> findPeakElementRange(int[] nums,int l,int r){
	   int left=l,right=r,mid=(left+right)/2;  
	   List<Integer> list=new ArrayList<Integer>();
	   while(left!=mid&&mid!=right){
		   if(nums[left]>=nums[mid]) return findPeakElementRange(nums,left,mid);
		   else if(nums[right]>=nums[mid]) return findPeakElementRange(nums,mid,right);
		   else{ 
			   List<Integer> list1=findPeakElementRange(nums,left,mid),list2=findPeakElementRange(nums,mid,right);
			   if(list1.get(0)>list2.get(0))
			   return list1;
			    else
			   return list2;
		   }
	   }
	   if(nums[left]>nums[right]){
		   list.add(nums[left]);
		   list.add(left);
	   }
	   else{
		   list.add(nums[right]);
		   list.add(right);
	   }
	   return list;
   }
   
   public static void main(String[] args){
	   FindPeakElement162 f=new FindPeakElement162();
	   int [] nums={1,6,5,4,3,2,1};
	   int r=f.findPeakElement(nums);
	   System.out.println("result="+r);
   }
}
