package algorithm;

import java.util.Arrays;
import java.util.List;

public class PatchingArray330 {
	//AC 1ms  ע��nΪ���ֵ��ʱ�����Խ��   ÿ����һ����n ��һ����Ҫ���ǵ���Ϊn+n ��Ϊn+n-1һ���Կɴ�  
    public int minPatches(int[] nums, int n) {
        long i=1;
        int index=0,len=nums.length,rcount=0;
    	while(i<=n){
           if(index<len&&nums[index]==i){
        	   index++;
           }else{   //������û�е�ǰֵ 
        	   rcount++;
           }
           i=i+i-1;
           while(index<len&&i>=nums[index]){   //�����е����ȵ�ǰֵС ���������ɴ�ֵ�÷�Χ    
        	   i=i+nums[index++];
           }
           i++;
        }
    	return rcount;
    }
    
    public static void main(String[] args){
    	PatchingArray330 p=new PatchingArray330();
    	int[] nums={1,2,31,33};
    	int r=p.minPatches(nums, 2147483647);
    	System.out.println("r="+r);
    }
}
