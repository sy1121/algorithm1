package algorithm;

public class NextPermutation31 {
	//AC 2ms
    public void nextPermutation(int[] nums) {
        int len=nums.length,i=len-2,j=len-1;
        boolean flag=false;
        if(len==1)  return ;
        for(;i>=0;i--){
        	j=len-1;
        	for(;j>i;j--){
        		if(nums[i]<nums[j]){
        			flag=true;break;
        		}	
        	}
        	if(flag) break;
        }
        if(flag)
        swap(nums,i,j);
        int left=i+1,right=len-1;
        while(left<right){
        	swap(nums,left++,right--);
        }
    }
    
    public void swap(int[] nums,int i,int j){
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    public static void main(String[] args){
    	NextPermutation31 n=new NextPermutation31();
    	int[] nums={4,2,0,2,3,2,0};
    	n.nextPermutation(nums);
    	for(int i=0;i<nums.length;i++){
    		System.out.print(nums[i]+",");
    	}
    }
}
