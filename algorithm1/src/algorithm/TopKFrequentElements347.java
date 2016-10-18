package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements347 {
	//35ms  HashMap 加桶排序
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list=new ArrayList<Integer>();
	    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	    int len=nums.length,maxCount=1;
	    for(int i=0;i<len;i++){
	    	if(map.containsKey(nums[i])){
	    		int temp=map.get(nums[i]);
	    	   map.put(nums[i], temp+1);
	    	   if(temp+1>maxCount) maxCount=temp+1;
	    	}else {
	    	   map.put(nums[i], 1);
	    	}
	    }
	    //
	    List<List<Integer>> num=new ArrayList<List<Integer>>();
	    for(int i=0;i<maxCount;i++){
	    	ArrayList<Integer> nlist=new ArrayList<Integer>();
	    	num.add(nlist);
	    }
	    
	    Iterator<Map.Entry<Integer,Integer>> ite=map.entrySet().iterator();
	    while(ite.hasNext()){
	    	Map.Entry<Integer,Integer> entry= ite.next();
	         num.get(entry.getValue()-1).add(entry.getKey());
	    } 
	   
	    int rcount=0;
		for(int i=maxCount-1;i>=0;i--){
			for(int j=0;j<num.get(i).size();j++){
				list.add(num.get(i).get(j));
				rcount++;
				if(rcount==k) return list;
			}
		}
		return list;
    }
	
	public static void main(String[] args){
		TopKFrequentElements347 t=new TopKFrequentElements347();
	    List<Integer> r=t.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
	    for(int i=0;i<r.size();i++){
	    	System.out.print(r.get(i)+",");
	    }
	    System.out.println();
	}
}
