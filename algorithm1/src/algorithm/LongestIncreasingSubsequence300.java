package algorithm;

public class LongestIncreasingSubsequence300 {
	//AC 80ms  O��N2�����Ӷ�
/*	 public int lengthOfLIS(int[] nums) {
	     int len=nums.length,result=1;  
	     if(len<1) return 0;
		 int[] count=new int[len];//��iԪ��λ��β�������������
		 //��ʼ��Ϊ1
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
	 //AC 1ms  O(nlogn)���Ӷ�
	 public int lengthOfLIS(int[] nums) {
		 int len=nums.length,result=1;
	     if(len<1) return 0;
		 int[] index=new int[len];//��¼����Ϊi�ĵ��������еĽ�βԪ������С��Ԫ��  �����Ľ��Ϊ��������Ԫ�صĸ���
		 index[0]=nums[0];
	     for(int i=1;i<len;i++){
	    	 if(nums[i]<index[0]) index[0]=nums[i]; //�滻��һ��Ԫ��
	    	 else if(nums[i]>index[result-1]) index[result++]=nums[i]; //����������еĳ��ȼ�һ
	    	 else{
	    	    	 int r=getIndex(index,nums[i],result);  //��ǰԪ��Ӧ���滻Index�е��ĸ�Ԫ��
	    	    	 if(r==-1) continue; 
	    	    	 else index[r]=nums[i];
	    	 }
	     }
	     return result;
	 }
	 //����-1 ��ʾ ��Ԫ���Ѿ���index�����У� ��index[i]<num<index[i+1],��i+1����Ҫ�滻��Ԫ��
	 public int  getIndex(int[] index,int num,int len){
		    int right=len-1,left=0,mid;
		    if(index[left]==num||index[right]==num) return -1;
		    while(left<right){
		    	mid=(left+right)>>1;  //���������bug,����������ѭ��
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
		    	//if(left+1==right) break;  //���������bug, 
		    }
		    return -1;
	 }
	 public static void main(String[] args){
		 LongestIncreasingSubsequence300 l=new LongestIncreasingSubsequence300();
		 int r=l.lengthOfLIS(new int[]{3,5,6,2,5,4,19,5,6,7,12});
		 System.out.println("result="+r);
	 }
}
