package algorithm;

public class KthLargestElementinanArray215 {
	
	//AC 31ms  直接选择排序
  /*public int findKthLargest(int[] nums, int k) {
        int size=nums.length;
        if(k<(size/2))
        	return selSortDESC(nums,k);
        else
        	return selSortASC(nums,size-k+1);
    }
  public int selSortDESC(int[] nums,int k){
	  int size=nums.length,maxIndex;
	  for(int i=0;i<k;i++){
		  maxIndex=i;
		 for(int j=i+1;j<size;j++){
			 if(nums[maxIndex]<nums[j]) maxIndex=j;
		 }
		 swap(nums,i,maxIndex);
	 }
	  return nums[k-1];
  }
  
  public int selSortASC(int[] nums,int k){
	  int size=nums.length,minIndex;
	  for(int i=0;i<k;i++){
		  minIndex=i;
		 for(int j=i+1;j<size;j++){
			 if(nums[minIndex]>nums[j]) minIndex=j;
		 }
		 swap(nums,i,minIndex);
	 }
	  return nums[k-1];
  }*/
  
  public void swap(int[] nums,int i,int j){
	  int temp;
	  temp=nums[i];
	  nums[i]=nums[j];
	  nums[j]=temp;
  }
  //根据快排划分的思想    AC 47ms
  public int findKthLargest(int[] nums, int k) {
	   int len=nums.length,left=0,right=len-1;
	   int mid=partition(nums,left-1,right);
	   swap(nums,mid,right);
	   while(mid!=len-k){
		   if(mid>len-k){
	           right=mid-1;  
			   mid=partition(nums,left-1,right);
			   swap(nums,mid,right);
		   }else{
			   left=mid+1;
			   mid=partition(nums,left-1,right);
			   swap(nums,mid,right);
		   }
	   }
	   return nums[mid];
  }
  
  
  public void quicksort(int[] nums,int left,int right){
	  if(left>right) return ;
	  int k=partition(nums,left-1,right);
	  swap(nums,right,k);
	  quicksort(nums,left,k-1);
	  quicksort(nums,k+1,right);
  }
  
  public int partition(int[] nums,int left,int right){
	  int pivot=nums[right];
	  while(left<right){
	     while(left<right&&nums[++left]<pivot);
	     while(right!=0&&nums[--right]>pivot);
	    	 swap(nums,left,right);
	  }
	  swap(nums,left,right);
	  return left;
  }
  
  public static void main(String[] args){
	  KthLargestElementinanArray215 k=new KthLargestElementinanArray215();
	  int[] nums={7,-8,-1,0,3,9};
	  int result=k.findKthLargest(nums, 2);
	   System.out.println("result="+result);
	  k.quicksort(nums, 0, nums.length-1); 
	  for(int i=0;i<nums.length;i++){
		  System.out.print(nums[i]+" ");
	  }
	  
  }
}
