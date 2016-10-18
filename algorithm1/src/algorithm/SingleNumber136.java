package algorithm;

public class SingleNumber136 {
	//AC 2ms 两个相同的数异或结果是0  0和任何数异或等于这个数  1和任何数异或等于这个数的各个位取相反数   异或操作是满足交换律和结合律的
    //状态机的思想  接受一个参数两次回到初始状态
	public int singleNumber(int[] nums) {
	    if(nums.length==0)  return 0;
        for(int i=1;i<nums.length ;i++){
            nums[i]=nums[i]^nums[i-1];
        }
	   return nums[nums.length-1];
    }
   
   public static void main(String[] args){
	   SingleNumber136 s=new SingleNumber136();
	   int[]  nums={1,2,1};
	   int r=s.singleNumber(nums);
	   System.out.println("r="+r);
   }
}
