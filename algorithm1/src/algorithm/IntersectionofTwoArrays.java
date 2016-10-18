package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectionofTwoArrays {
	//6ms  Hashset
   /*public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<Integer>();
        HashSet<Integer> rset=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
        	set.add(nums1[i]);
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums2.length;i++){
        	if(set.contains((Integer)nums2[i])&&!rset.contains((Integer)nums2[i])){
        		list.add(nums2[i]);
        	    rset.add(nums2[i]);
        	}
        	
        }
        int[] r=new int[list.size()];
        for(int i=0;i<list.size();i++){
        	r[i]=list.get(i);
        }
        return r;
    }*/
	
	//5ms two points
	public int[] intersection(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list=new ArrayList<Integer>();
		int i=0,j=0,size1=nums1.length,size2=nums2.length;
		while(i<size1&&j<size2){
			if(nums1[i]==nums2[j]&&(list.isEmpty()||list.get(list.size()-1)!=nums1[i])){
				list.add(nums1[i]);
				i++;
				j++;
			}else if(nums1[i]>nums2[j]){
				j++;
			}else{
				i++;
			}
		}
		
		 int[] r=new int[list.size()];
	        for(int k=0;k<list.size();k++){
	        	r[k]=list.get(k);
	        }
	        return r;
	}
}
