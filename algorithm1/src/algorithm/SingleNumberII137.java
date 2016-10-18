package algorithm;

public class SingleNumberII137 {
    //AC  6ms
	 public int singleNumber(int[] nums) {
		 int[] r=new int[32];
		 int c=0,result=0,y=1;
		 for(int i=0;i<32;i++){
			 int sum=0;
			 for(int j=0;j<nums.length;j++){
				 sum=sum+(nums[j]&1);
				 nums[j]=(nums[j]>>1);
			 }
			 r[c++]=sum%3;
		 }
		 for(int i=0;i<32;i++){
			 result=result+r[i]*y;
			 y=y<<1;
		 }
		 return result;
	    }
	 //别人的简洁写法
/*	   public static int singleNumber(int[] nums) {
		    int len = nums.length, result = 0;
		    for (int i = 0; i < 32; i++) {
		        int sum = 0;
		        for (int j = 0; j < len; j++) {
		            sum += (nums[j] >> i) & 1;
		        }
		        result |= (sum % 3) << i;
		    }
		    return result;
		}*/
	 public static void main(String[] args){
		 SingleNumberII137 s=new SingleNumberII137();
		 int[] nums={2,2,3,2};
		 int r=s.singleNumber(nums);
		 System.out.println("r="+r);
	 }
}
