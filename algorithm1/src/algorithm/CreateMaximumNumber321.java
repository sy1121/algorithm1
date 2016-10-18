package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreateMaximumNumber321 {
	 public int[] maxNumber(int[] nums1, int[] nums2, int k) {
	        int[]  r=new int[k];
	        int size1=nums1.length,size2=nums2.length,index=0;
            List<Integer> rlist=maxHelper(nums1,0,nums2,0,k);  
            for(int i=0;i<rlist.size();i++){
            	r[i]=rlist.get(i);
            }
            return r;
            
	    }
	 
	 public List<Integer> maxHelper(int[] nums1,int index1,int[] nums2,int index2,int k){
		   if(k<0) return null;
		   List<Integer> list=new ArrayList<Integer>();
		   int tail1=(k-nums2.length>0)?nums1.length-(k-nums2.length):nums1.length-1;
		   int tail2=(k-nums1.length>0)?nums2.length-(k-nums1.length):nums2.length-1;
		   int[] r1=getMax(nums1,index1,tail1);
		   int[] r2=getMax(nums2,index2,tail2);
		   if(r1[0]>r2[0]){
			   list.add(r1[0]);
			   List<Integer> temp=maxHelper(nums1,r1[1]+1,nums2,index2,k-1);
			   for(int i=0;temp!=null&&i<temp.size();i++){
				   list.add(temp.get(i));
			   }
		   }else if(r1[0]<r2[0]){
			   list.add(r2[0]);
			   List<Integer> temp=maxHelper(nums1,index1,nums2,r2[1]+1,k-1);
			   for(int i=0;temp!=null&&i<temp.size();i++){
				   list.add(temp.get(i));
			   }
		   }else{
			   list.add(r1[0]);
			   List<Integer> temp1=maxHelper(nums1,r1[1]+1,nums2,index2,k-1);
			   List<Integer> temp2=maxHelper(nums1,index1,nums2,r2[1]+1,k-1);
			   for(int i=0;i<temp1.size();i++){
				   if(temp1.get(i)>temp2.get(i))
					   list.add(temp1.get(i));
				   else
					   list.add(temp2.get(i));
			   }
		   }
		   return list;
	 }
	 
	 public int[] getMax(int[] nums,int left,int right){
		 int[] r=new int[2];
		 if(left>=nums.length) 
			 return r;
		 int temp=nums[left],index=left;
		 for(int i=left+1;i<=right;i++){
			 if(temp<nums[i]){
				 temp=nums[i];
				 index=i;
			 }
		 }
		 r[0]=temp;
		 r[1]=index;
		 return r;
	 }
	 
	 public static void main(String[] args){
		 CreateMaximumNumber321 c=new CreateMaximumNumber321();
		 int[] nums1={3,4,6,5};
		 int[] nums2={9,1,2,5,8,3};
		 int[] r=c.maxNumber(nums1,nums2,5);
		 for(int i=0;i<r.length;i++){
			 System.out.print(r[i]+" ");
		 }
	 }
	
}
