package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegers29 {
	//AC 4ms 
	//思路：找到第一个大于dividend的divisor的2的n次方被的数 在用二分查找的思想在2的n-1次方被到2的n次方贝中找
	  int divide(int dividend, int divisor) {
	   	   if(divisor==0) return Integer.MAX_VALUE;
	   	   long  Ldend=dividend,Lsor=divisor;
	   	   int dendsign=(dividend>>31)&1;   //获取符号
	   	   int sorsign=(divisor>>31)&1;
	   	   long dend=Math.abs(Ldend),sor=Math.abs(Lsor),temp;  //都转成long型，为了好处理最大的负整数，取绝对值
	   	   long result=0;    
	    	if(dend<sor) return 0;
	    	else if(dend==sor) {
	    		result=1;
	    	}else{
	         int size=0,max;
	         temp=sor;
	        while(temp<dend){    //找到大于dividend的divisor的2的n被
	        	size++;
	        	temp<<=1;
	        }
	        long rightIndex=((long)1)<<size,leftIndex=rightIndex>>1;
	        long left=temp>>1;
	        long right=temp,mid=0;
	        long midIndex;
	        if(right==dend) result=rightIndex;
	        else{
	        while(left<right){   //二分查找
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
	    	
	        if((dendsign^sorsign)==0)   //在结果上加上符号
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
