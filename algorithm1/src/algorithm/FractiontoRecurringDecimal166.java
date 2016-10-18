package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FractiontoRecurringDecimal166 {
	
	//AC 5ms
	  public String fractionToDecimal(int numerator, int denominator) {
		  long numerator1=0L,denominator1=0L; 
		  numerator1=Math.abs((long)numerator);
		  denominator1=Math.abs((long)denominator);
		  String s="";  //符号
		   if(numerator>0&&denominator<0||numerator<0&&denominator>0) s="-";
	      long ipart=0; //整数部分的值
	      int dcount=0;  //小数部分有几位
	      boolean flag=false;  //是否是循环小数
	      StringBuilder dpartString=new StringBuilder("");  //小数部位构成的字符串
	      List<Long> dpart=new ArrayList<Long>();   //存储小数部分每一位的值得列表
	      HashMap<Long,Integer> num=new HashMap<Long,Integer>(); //在计算循环小数的时候，计算出现过的被除数，以确定循环从哪一位开始
	      if(numerator1>denominator1){    //先计算整数部分  
	    	   ipart=numerator1/denominator1;
	    	   numerator1=numerator1%denominator1;
	       }
		   if(numerator1==0) return s+ipart+"";   //如果整除，即没有小数部分，直接返回
		   numerator1*=10;          //得到的余数，乘以10 继续计算
		   while(numerator1!=0){     //知道整除，即余数为零
			   if(num.containsKey(numerator1)){   //被除数出现过说明是一个循环小数
				   flag=true;     //设置循环小数标志 ，
				   break;     //退出循环
			   }
			   while(numerator1<denominator1){  //如果当前被除数比分母小
				   dpart.add(0L);   //小数部分上0
				   dcount++;        //小数位数加1
				   num.put(numerator1, dcount);  //把当前的被除数加入hashMap中，为后面确定循环小数
				   numerator1*=10;    //被除数乘以10
			   }
			   long  d=numerator1/denominator1;   //计算小数部分上几
			   dpart.add(d);    //和while一样
			   dcount++;      //小数部分加1
			   num.put(numerator1, dcount);
			   numerator1=numerator1%denominator1;
			   numerator1*=10;
		   }
		   
		   //开始拼接小数部分
		    if(flag){  //如果是循环小数
		    	 int repindex=num.get(numerator1)-1; //计算小部分从哪一位开始循环
		    	for(int i=0;i<dpart.size();i++){ //依次输出每一位  
		    		if(i==repindex)   // 循环开始位前加“（”
			            dpartString.append("("+dpart.get(i));
		    		else
		    			dpartString.append(dpart.get(i));
		    	}
		    	dpartString.append(")");
		    }else{   //不是循环小数，直接输出每一位
		    	for(long i:dpart){
		    		dpartString.append(i);
		    	}
	    	}
		   //拼接上整数部分和符号
		   return s+ipart+"."+dpartString;
		   
	    }
	  
	  public static void main(String[] args){
		  FractiontoRecurringDecimal166 f=new FractiontoRecurringDecimal166();
		  String r=f.fractionToDecimal(-2147483648,1);
		  System.out.println("r="+r);
	  }
}
