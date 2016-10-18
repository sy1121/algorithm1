package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII229 {
    //最多只有两个元素会出现次数超过n/3次   AC 5ms
/*	public List<Integer> majorityElement(int[] nums) {
           int p=0,pcount=0,q=0,qcount=0,len=nums.length;
           List<Integer> list=new ArrayList<Integer>();
           if(len<1) return list;
           for(int num:nums){
        	   if(num!=q&&pcount==0){
        		   p=num;
        		   pcount++;
        	   }else if(num!=p&&qcount==0){
        		   q=num;
        		   qcount++;
        	   }else{
        		   if(p==num) pcount++;
        		   else if(q==num)qcount++;
        		   else {
        			   qcount--;pcount--;
        		   }
        	   }
           }
           int ppcount=0,qqcount=0;
           for(int i=0;i<len;i++){
        	  if(pcount>0&&nums[i]==p) ppcount++;
        	  if(qcount>0&&nums[i]==q) qqcount++;
           }
          if(ppcount>len/3) list.add(p);
          if(qqcount>len/3) list.add(q);
          return list;
    }*/
	//一个这类问题的通用解法 O(n)时间 O(1)复杂度
	public List<Integer> majorityElement(int[] nums) {
		return helper(nums,3);
	}
	public List<Integer> helper(int[] nums,int k){
		  List<Integer> list=new ArrayList<Integer>();
		  int len=nums.length;
		  if(len<1) return list;
		  HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		  List<Integer> temp=new ArrayList<Integer>();
		  for(int n:nums){
			  if(map.containsKey(n)) map.put(n,map.get(n)+1);
			  else if(map.size()<k-1) map.put(n, 1);
			  else{
				for(Integer key:map.keySet()){
				    if(map.get(key)==1) temp.add(key);
				    else
					map.put(key,map.get(key)-1);
			    }
			    for(int i=0;i<temp.size();i++){
			    	map.remove(temp.get(i));
			    }
			    temp.clear();
			  }
		  }
		  for(Integer key:map.keySet()){
			   map.put(key, 0);
		  }
		  for(Integer n:nums){
			  if(map.containsKey(n)) map.put(n, map.get(n)+1);
		  }
		  
		  for(Integer key:map.keySet()){
			  if(map.get(key)>(len/k)) list.add(key);
		  }
		  return list;
	}
	
	public static void main(String[] args){
		MajorityElementII229 m=new MajorityElementII229();
		int[] nums={1,2,2,3,2,1,1,3};
		List<Integer> rlist=m.majorityElement(nums);
		for(int i=0;i<rlist.size();i++){
			System.out.print(rlist.get(i)+",");
		}
	}
}
