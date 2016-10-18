package algorithm;

import java.util.Arrays;

public class HIndex274 {
	
	//AC 3ms
    public int hIndex(int[] citations) {
        //先排序
	   Arrays.sort(citations);
	   //再二分查找
	   int len=citations.length,left=0,right=len-1,size=len,index=-1,value;
	   int lastleft=1;
	   if(len==0) return 0;
	   if(len==1) return citations[0]>0?1:0;
	   while(left+1<right){
		   index=(left+right)/2;
		   size=len-index;
		   value=citations[index];
		   if(size>value) {
			   left=index;
			   lastleft=1;
		   }
		   else if(size<value){
			   right=index;
			   lastleft=2;
		   }
		   else  return size;
	   }
	   if(lastleft==1){
		   if(citations[left]<size) size--;
		   if(citations[right]<size) size--;
	   }else if(lastleft==2){
		   if(citations[right]<size) size--;
		   else if(citations[left]>size) size++;
	   }
	   return  size;
    }
/*	 网上看的O(n)的解法   
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n < 1) return 0;
        int[] cnt = new int[n + 1];

        for (int i : citations)   //桶排序
            cnt[Math.min(i, n)]++;

        for (int i = n, sum = 0; i >= 0; i--) {
            sum += cnt[i];
            if (sum >= i) return i;
        }
        return 0;
    }*/
	   public static void main(String[] args){
		   HIndex274 h=new HIndex274();
		   int[] citations={7,7,7,7,7,7,7};
		   int result=h.hIndex(citations);
		   System.out.println("result="+result);
	   }
}
