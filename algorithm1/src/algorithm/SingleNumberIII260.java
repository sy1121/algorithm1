package algorithm;

public class SingleNumberIII260 {
	
	//AC 3ms
	/**
	 * 先按照I中的方式得到两个仅出现一次的两个数的异或值 然后要把这两个数分离出来  
	 * 要区别这两个数，只要知道这个两个数二进制表示中不同的某一位 然后让他们都和这一位是1其他位都是0的数相与 必有一个结果为1另一个结果为0；
	 * 对其他的数也进行这个操作 这样就可以根据这意味的情况将数组的数分为两拨 ，相同的两个数一定被分到同一拨  ,这样上这两拨数再做异或操作 则可
	 * 以分别得到要找的这两个只出现依次的数
	 * @param nums
	 * @return
	 */
   public int[] singleNumber(int[] nums) {
	   int size=nums.length;
	   int[] r=new int[2];
	   int temp=0,diff;
       if(size<2) return new int[]{};
       for(int i=0;i<size;i++){
    	   temp=temp^nums[i];
       }
       r[0]=0;
       r[1]=0;
       diff=temp&(temp-1)^temp;
       for(int i=0;i<size;i++){
    	   if((nums[i]&diff)!=0){
    		  r[0]=(r[0]^nums[i]);
    	   }else{
    		   r[1]=(r[1]^nums[i]);
    	   }
    	  
       }
	   return r; 
    }
}
