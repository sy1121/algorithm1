package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers29 {
	//AC 4ms 
	//˼·���ҵ���һ������dividend��divisor��2��n�η������� ���ö��ֲ��ҵ�˼����2��n-1�η�����2��n�η�������
	  int divide(int dividend, int divisor) {
	   	   if(divisor==0) return Integer.MAX_VALUE;
	   	   long  Ldend=dividend,Lsor=divisor;
	   	   int dendsign=(dividend>>31)&1;   //��ȡ����
	   	   int sorsign=(divisor>>31)&1;
	   	   long dend=Math.abs(Ldend),sor=Math.abs(Lsor),temp;  //��ת��long�ͣ�Ϊ�˺ô������ĸ�������ȡ����ֵ
	   	   long result=0;    
	    	if(dend<sor) return 0;
	    	else if(dend==sor) {
	    		result=1;
	    	}else{
	         int size=0,max;
	         temp=sor;
	        while(temp<dend){    //�ҵ�����dividend��divisor��2��n��
	        	size++;
	        	temp<<=1;
	        }
	        long rightIndex=((long)1)<<size,leftIndex=rightIndex>>1;
	        long left=temp>>1;
	        long right=temp,mid=0;
	        long midIndex;
	        if(right==dend) result=rightIndex;
	        else{
	        while(left<right){   //���ֲ���
	        	 mid=(left+right)/2;
	        	 midIndex=(leftIndex+rightIndex)/2;
	        	 if(mid>dend) {
	        		 right=mid;
	        		 rightIndex=midIndex;
	        	 }
	        	 else if(mid<dend) {
	        		 left=mid;
	        		 leftIndex=midIndex;
	        	 }
	        	 else {
	        		 result=midIndex;
	        		 break;
	        	 }
	          }
	    	 }
	    	}
	    	
	        if((dendsign^sorsign)==0)   //�ڽ���ϼ��Ϸ���
	           return result>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)result;
	        else
	        	return -((int)result);
	    }
	

    
    public static void main(String[] args){
    	DivideTwoIntegers29 d=new DivideTwoIntegers29();
    	int r=d.divide(2147483647, -1);
    	System.out.println("r="+r);
    }
}
