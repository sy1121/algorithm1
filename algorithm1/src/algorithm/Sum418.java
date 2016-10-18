package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum418 {
	//AC 63ms
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rlist=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len=nums.length;
        if(len<4) return rlist;
        int left,right;
        for(int i=0;i<len-3;i++){
            if(i>0&&nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<len-2;j++){
                if(j>i+1&&nums[j-1]==nums[j]) continue;
                left=j+1;
                right=len-1;
                while(left<right){
                    int curSum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(curSum<target) left++;  
                    else if(curSum>target) right--;  
                    else{
                        rlist.add(Arrays.asList(nums[i],nums[j],nums[left++],nums[right--]));
                        while(left<right&&nums[left-1]==nums[left]) left++;
                        while(left<right&&nums[right+1]==nums[right]) right--;
                    }
                }
            }
        }
        return rlist;
    }
	  
	  public static void main(String[] args){
		  Sum418 f=new Sum418();
		  List<List<Integer>> r=f.fourSum(new int[]{-1,2,2,-5,0,-1,4}, 3);
		  for(int i=0;i<r.size();i++){
			  System.out.print("{");
			  for(int j=0;j<r.get(0).size();j++){
				  System.out.print(r.get(i).get(j)+",");
			  }
			  System.out.println("}");
		  }
	  }
}
