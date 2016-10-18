package algorithm;

import java.util.HashSet;

public class ContainsDuplicateII219 {
	//AC  10ms
   public boolean containsNearbyDuplicate(int[] nums, int k) {
            int size=nums.length ;
            if(size==0)  return false;
            HashSet<Integer> set=new HashSet<Integer>();
            for(int i=0;i<size;i++){
            	if(!set.add(nums[i])) return true;
            	if(set.size()>k) set.remove(nums[i-k]);
            }
            return false;
    }
}
