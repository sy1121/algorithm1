package algorithm;

public class SingleNumber136 {
	//AC 2ms ������ͬ�����������0  0���κ��������������  1���κ���������������ĸ���λȡ�෴��   �����������㽻���ɺͽ���ɵ�
    //״̬����˼��  ����һ���������λص���ʼ״̬
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
