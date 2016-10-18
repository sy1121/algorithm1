package sort;

public class HeapSort {
    private static void  heapSort(int[] nums){
    	buildHeap(nums);
    	for(int i=nums.length-1;i>0;i--){
    		swap(nums,i,0);
    		siftDown(0,nums,i-1);
    	}
    }
    
    private static void buildHeap(int[] nums){
    	int len=nums.length;
    	for(int i=len/2-1;i>=0;i--){
    		siftDown(i,nums,len);
    	}
    }
    
    private static void siftDown(int i,int[] nums,int count){
    	while(!isLeaf(i,nums.length)){
    		int maxIndex=2*i+1;
    		if((maxIndex+1<count)&&nums[maxIndex]<nums[maxIndex+1])
    			maxIndex=maxIndex+1;
    		if(nums[maxIndex]<=nums[i]) return ;
    		swap(nums,i,maxIndex);
    		i=maxIndex;
    	}
    }
    
    private static void swap(int[] nums,int a,int b){
    	int temp=nums[a];
    	nums[a]=nums[b];
    	nums[b]=temp;
    }
    
    private static boolean isLeaf(int i,int count){
    	return i<count&&i>=(count/2);
    }
    
    public static void main(String[] args){
    	HeapSort h=new HeapSort();
        int[] nums={3,4,5,2,5,3,5,3,6};
    	h.heapSort(nums);
    	for(int i=0;i<nums.length;i++){
    		System.out.print(nums[i]+" ");
    	}
    }
}
