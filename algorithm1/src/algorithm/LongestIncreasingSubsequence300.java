package algorithm;

public class LongestIncreasingSubsequence300 {
	//AC 80ms  O（N2）复杂度
/*	 public int lengthOfLIS(int[] nums) {
	     int len=nums.length,result=1;  
	     if(len<1) return 0;
		 int[] count=new int[len];//第i元素位结尾的最长递增子序列
		 //初始化为1
		 count[0]=1;
		 for(int i=1;i<len;i++){
			 count[i]=1;
			 for(int j=0;j<i;j++){
				 if(nums[j]<nums[i]){
					 count[i]=count[j]+1>count[i]?count[j]+1:count[i];
				 }
			 }
			 if(result<count[i])  result=count[i];
		 }
		 return result;
	    }*/
	 //AC 1ms  O(nlogn)复杂度
	 public int lengthOfLIS(int[] nums) {
		 int len=nums.length,result=1;
	     if(len<1) return 0;
		 int[] index=new int[len];//记录长度为i的递增子序列的结尾元素中最小的元素  ，最后的结果为该数组中元素的个数
		 index[0]=nums[0];
	     for(int i=1;i<len;i++){
	    	 if(nums[i]<index[0]) index[0]=nums[i]; //替换第一个元素
	    	 else if(nums[i]>index[result-1]) index[result++]=nums[i]; //最长递增子序列的长度加一
	    	 else{
	    	    	 int r=getIndex(index,nums[i],result);  //当前元素应该替换Index中的哪个元素
	    	    	 if(r==-1) continue; 
	    	    	 else index[r]=nums[i];
	    	 }
	     }
	     return result;
	 }
	 //返回-1 表示 该元素已经在index数组中， 若index[i]<num<index[i+1],则i+1是需要替换的元素
	 public int  getIndex(int[] index,int num,int len){
		    int right=len-1,left=0,mid;
		    if(index[left]==num||index[right]==num) return -1;
		    while(left<right){
		    	mid=(left+right)>>1;  //这个程序有bug,这里会出现死循环
		    	if(index[mid]==num) return -1;
		    	else if(index[mid]<num){
		    		if(mid+1<len&&index[mid+1]>num)
		    			return mid+1;
		    		else{
		    		    left=mid;
		    		}
		    	}else{
		    		right=mid;
		    	}
		    	//if(left+1==right) break;  //这个程序有bug, 
		    }
		    return -1;
	 }
	 public static void main(String[] args){
		 LongestIncreasingSubsequence300 l=new LongestIncreasingSubsequence300();
		 int r=l.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
		 System.out.println("result="+r);
	 }
}
