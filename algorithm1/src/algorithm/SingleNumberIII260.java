package algorithm;

public class SingleNumberIII260 {
	
	//AC 3ms
	/**
	 * �Ȱ���I�еķ�ʽ�õ�����������һ�ε������������ֵ Ȼ��Ҫ�����������������  
	 * Ҫ��������������ֻҪ֪����������������Ʊ�ʾ�в�ͬ��ĳһλ Ȼ�������Ƕ�����һλ��1����λ����0�������� ����һ�����Ϊ1��һ�����Ϊ0��
	 * ����������Ҳ����������� �����Ϳ��Ը�������ζ����������������Ϊ���� ����ͬ��������һ�����ֵ�ͬһ��  ,������������������������ ���
	 * �Էֱ�õ�Ҫ�ҵ�������ֻ�������ε���
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
