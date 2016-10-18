package algorithm;

public class MajorityElement169 {
	//AC 4ms
	public int majorityElement(int[] nums) {
        int len=nums.length;
        if(len<2) return nums[0];
        int head=0,tail=1,result=nums[0];
        int[] mark=new int[len];
        while(tail<len&&head<tail){
            if(nums[head]!=nums[tail]){
                 mark[head]=1;mark[tail]=1;
                 head++;tail++;
            }else{
                tail++;
            }
            while(mark[head]==1) head++;
            while(tail<len&&(mark[tail]==1||tail<=head)) tail++;
        }
        
        for(int i=0;i<len;i++){
            if(mark[i]==0) {
                result=nums[i];break;
            }
        }
        return result;
    }
	
	//网上的方法
/*	public int majorityElement1(int[] nums) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int num: nums) {
	        if (map.containsKey(num))
	            map.put(num, map.get(num) + 1);
	        else
	            map.put(num, 1);
	        if (map.containsKey(num) && map.get(num) > nums.length/2)
	            return num;
	    }
	    return -1;
	}

	public int majorityElement2(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}

	// Moore's majority vote method
	public int majorityElement(int[] nums) {
	    int majority = 0;
	    int count = 0;
	    for (int num: nums) {
	        if (count == 0)
	            majority = num;
	        if (num == majority)
	            count ++;
	        else 
	            count--;
	    }
	    return majority;
	}*/
}
