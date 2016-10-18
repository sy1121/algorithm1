package algorithm;

public class RotateArray189 {
	//AC 1ms
	 public void rotate(int[] nums, int k) {
	        int len=nums.length;
	        k=k%len;
	        if(k<=0||k>=len) return ;
	        int index=0,swaped=0,count=len-1,tindex=0;
	        int temp=nums[0];
	        while(count>0){
	        if(index<k) swaped=index+len-k;
	        else swaped=index-k;
	        if(swaped==tindex){
	        	nums[index]=temp;
	        	tindex++;
	        	index=tindex;
	        	temp=nums[tindex];
	        	count--;
	        	continue;
	        }
	        nums[index]=nums[swaped];
	        index=swaped;
	        count--;
	        }
	       
	    nums[index]=temp;
	    }
	 
	 public static void main(String[] args){
		 RotateArray189 r=new RotateArray189();
		 int[] nums={1,2,3,4,5,6};
		 r.rotate(nums, 2);
		 for(int i=0;i<nums.length;i++){
			 System.out.print(nums[i]+",");
		 }
	 }
}
